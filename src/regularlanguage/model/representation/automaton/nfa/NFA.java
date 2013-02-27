/*
 * Copyright (C) 2013 Felix Wiemuth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package regularlanguage.model.representation.automaton.nfa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import regularlanguage.model.RepresentationCollection;
import regularlanguage.model.representation.automaton.Automaton;
import regularlanguage.model.representation.automaton.State;
import regularlanguage.model.representation.automaton.dfa.DFA;
import regularlanguage.model.representation.automaton.dfa.DFAState;
import static regularlanguage.util.Util.*;

/**
 * A representation of a nondeterministic finite automaton (NFA).
 *
 * @author Felix Wiemuth
 */
public class NFA extends Automaton {

    private Set<NFAState> states;
    private Set<Object> alphabet;
    private Set<NFAState> startStates;
    private Set<NFAState> acceptStates;

    /**
     * Create a new NFA using an existing representation collection. The NFA
     * component of the representation collection will be overwritten with the
     * new NFA.
     *
     * @param states
     * @param alphabet
     * @param startStates
     * @param acceptStates
     * @param name
     */
    public NFA(Set<NFAState> states, Set<Object> alphabet, Set<NFAState> startStates, Set<NFAState> acceptStates, String name) {
        this(states, alphabet, startStates, acceptStates, name, new RepresentationCollection());
    }

    public NFA(Set<NFAState> states, Set<Object> alphabet, Set<NFAState> startStates, Set<NFAState> acceptStates, String name, RepresentationCollection representations) {
        super(name, representations);
        this.states = states;
        this.alphabet = alphabet;
        this.startStates = startStates;
        this.acceptStates = acceptStates;
    }

    //TODO implement
    @Override
    public boolean satisfiesDefintion() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean accepts(Iterable<Object> word) {
        debugLog("NFA " + getName() + ": Checking a word...\nStarting at\n" + getStateSetAsString(startStates));
        NFAConfig config = new NFAConfig(startStates);
        for (Object a : word) {
            debugLog("--" + a + "-->");
            config.readSymbol(a);
            debugLog(getStateSetAsString(config.getStates()));
        }
        for (NFAState s : config.getStates()) {
            if (acceptStates.contains(s)) {
                return true;
            }
        }
        return false;
    }

    //TODO implement
    @Override
    public Set<State> getStates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the equivalent DFA to this NFA. The DFA is constructed the first time
     * this method is called and cached afterwards.
     *
     * @return
     */
    public DFA getDFA() {
        if (representations().getDFA() == null) {
            representations().setDFA(calculateDFA());
        }
        return representations().getDFA();
    }

    /**
     * Calculate an equivalent DFA, using the powerset construction.
     *
     * @return
     */
    private DFA calculateDFA() {
        debugLog("Starting to calculate DFA from NFA '" + getName() + "'");
        Map<Set<NFAState>, DFAState> dfaStates = new HashMap<>();
        DFAState dfaStartState = new DFAState();
        dfaStates.put(startStates, dfaStartState);

        Stack<Set<NFAState>> stack = new Stack<>();
        stack.push(startStates);

        while (!stack.empty()) {
            Set<NFAState> set = stack.pop();
            debugLog("Taking from stack to add transitions: State represented by set "
                    + getStateSetAsString(set)
                    + " = State " + dfaStates.get(set).getName());
            DFAState fromState = dfaStates.get(set);
            for (Object a : alphabet) {
                NFAConfig c = new NFAConfig(set);
                c.readSymbol(a);
                DFAState toState = dfaStates.get(c.getStates());
                if (toState == null) { //a new state that isn´t included in the map yet
                    toState = new DFAState();
                    dfaStates.put(c.getStates(), toState);
                    stack.push(c.getStates()); //transitions for the created state must be added later
                    debugLog("Pushed to stack for later procession: State represented by set "
                            + getStateSetAsString(c.getStates()) + " = State " + dfaStates.get(c.getStates()).getName());
                }
                fromState.setTransition(a, toState);
                debugLog("Set transition " + fromState.getName() + " --" + a + "--> " + toState.getName());
            }
        }
        Set<DFAState> dfaAcceptStates = new HashSet<>();

        for (Set<NFAState> set : dfaStates.keySet()) {
            for (NFAState s : set) {
                if (acceptStates.contains(s)) {
                    dfaAcceptStates.add(dfaStates.get(set));
                    break;
                }
            }
        }

        return new DFA(new HashSet<>(dfaStates.values()), alphabet, dfaStartState, dfaAcceptStates, getName() + "[NFA]");
    }

    private static String getStateSetAsString(Set<? extends State> set) {
        StringBuilder sb = new StringBuilder("(");
        for (State s : set) {
            sb.append(s.getName()).append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
