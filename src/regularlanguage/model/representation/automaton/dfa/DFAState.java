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

import java.util.HashMap;
import java.util.Map;
import regularlanguage.model.representation.automaton.State;

/**
 * A state of a DFA.
 * @author Felix Wiemuth
 */
public class DFAState extends State {

    private Map<Object, DFAState> transitions = new HashMap<>();

    public DFAState(String name) {
        super(name);
    }

    public DFAState() {
    }
    
    

//    public void setTransition(Object a, DFAState nextState) {
//        transitions.put(a, nextState);
//    }
    public DFAState getNextState(Object a) {
        return transitions.get(a);
    }

    public DFAState setTransition(Object a, DFAState state) {
        return transitions.put(a, state);
    }

    public DFAState removeTransition(Object a, DFAState state) {
        return transitions.remove(a);
    }

//    @Override
//    public boolean removeTransition(Object a, DFAState state) {
//        throw new UnsupportedOperationException("Not supported yet.");
//    }
}
