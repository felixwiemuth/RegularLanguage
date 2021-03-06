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

import java.util.HashSet;
import java.util.Set;

/**
 * A configuration of an NFA.
 * The configuration is identified by the set of the automatons current states.
 * @author Felix Wiemuth
 */
public class NFAConfig {
    private Set<NFAState> states;

    public NFAConfig(Set<NFAState> startStates) {
        this.states = new HashSet<>(startStates);
    }
    
    public void readSymbol(Object a) {
        Set<NFAState> newStates = new HashSet<>();
        for (NFAState s : states) {
            newStates.addAll(s.getNextStates(a));
        }
        states = newStates;
    }

    public Set<NFAState> getStates() {
        return states;
    }
    
    
    
    
}
