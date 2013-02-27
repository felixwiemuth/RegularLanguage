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
import regularlanguage.model.representation.automaton.State;

/**
 * A state of an NFA.
 * @author Felix Wiemuth
 */
public class NFAState extends State {
    private Map<Object, Set<NFAState>> transitions = new HashMap<>();

    public NFAState(String name) {
        super(name);
    }

    public NFAState() {
    }
    
    
    
    public void addTransition(Object a, NFAState state) {
        if (!transitions.containsKey(a)) {
            transitions.put(a, new HashSet<NFAState>());
        }
        transitions.get(a).add(state);
    }
    
    public Set<NFAState> getNextStates(Object a) {
        return transitions.get(a);
    }
    
}
