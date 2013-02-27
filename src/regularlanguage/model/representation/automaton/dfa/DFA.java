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
package regularlanguage.model.representation.automaton.dfa;

import java.util.Set;
import regularlanguage.model.RepresentationCollection;
import regularlanguage.model.representation.automaton.Automaton;
import regularlanguage.model.representation.automaton.State;
import regularlanguage.model.representation.automaton.nfa.NFA;

/**
 * A representation of a deterministic finite automaton (DFA).
 *
 * @author Felix Wiemuth
 */
public class DFA extends Automaton {

    private Set<DFAState> states;
    private Set<Object> alphabet;
    private DFAState startState;
    private Set<DFAState> acceptStates;

    /**
     * Create a new DFA.
     *
     * @param states
     * @param alphabet
     * @param startState
     * @param acceptStates
     * @param name
     */
    public DFA(Set<DFAState> states, Set<Object> alphabet, DFAState startState, Set<DFAState> acceptStates, String name) {
        this(states, alphabet, startState, acceptStates, name, new RepresentationCollection());
    }

    /**
     * Create a new DFA using an existing representation collection. The DFA
     * component of the representation collection will be overwritten with the
     * new DFA.
     *
     * @param states
     * @param alphabet
     * @param startState
     * @param acceptStates
     * @param name
     * @param representations
     */
    public DFA(Set<DFAState> states, Set<Object> alphabet, DFAState startState, Set<DFAState> acceptStates, String name, RepresentationCollection representations) {
        super(name, representations);
        this.states = states;
        this.alphabet = alphabet;
        this.startState = startState;
        this.acceptStates = acceptStates;
        representations.setDFA(this);
    }

    @Override
    public boolean accepts(Iterable<Object> word) {
        DFAConfig cfg = new DFAConfig(startState);
        for (Object a : word) {
            cfg.readSymbol(a);
        }
        return acceptStates.contains(cfg.getState());

    }

    /**
     * Checks whether this object represents a formal DFA. The following
     * conditions must be met: <ul> <li> The states must not contain a 'null'
     * value </li> <li> The accept states must be a subset of the states </li>
     * <li> The start state must be included in the states </li> <li> For all
     * states, a transition must be defined for each symbol of the alphabet and
     * the destination must be one of the states. </ul> It is allowed to have
     * additional transitions for characters not in the alphabet.
     *
     * @return
     */
    @Override
    public boolean satisfiesDefintion() {
        //check if 'states' does no contain a 'null' value
        if (states.contains(null)) {
            return false;
        }
        //check if the accept states are a subset of the states
        if (!states.containsAll(acceptStates)) {
            return false;
        }
        //check if the start state is one of the states
        if (!states.contains(startState)) {
            return false;
        }
        //check if all transitions are complete and go to states of this automaton
        for (DFAState s : states) {
            for (Object a : alphabet) {
                DFAState s2 = s.getNextState(a);
                if (!states.contains(s2)) {
                    return false;
                }
            }
        }
        return true; //all negative-checks passed
    }

    //TODO implement
    @Override
    public Set<State> getStates() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Get the equivalent NFA to this DFA. The NFA is constructed the first time
     * this method is called and cached afterwards.
     *
     * @return
     */
    public NFA getNFA() {
        if (representations().getNFA() == null) {
            representations().setNFA(calculateNFA());
        }
        return representations().getNFA();
    }

    //TODO implement
    private NFA calculateNFA() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
