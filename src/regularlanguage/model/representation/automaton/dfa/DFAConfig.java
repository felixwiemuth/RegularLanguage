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

/**
 * A configuration of a DFA.
 * The configuration is identified by the automatons current state.
 * @author Felix Wiemuth
 */
public class DFAConfig {

    private DFAState state;

    public DFAConfig(DFAState startState) {
        this.state = startState;
    }

    public void readSymbol(Object a) {
        state = state.getNextState(a);
    }

    public DFAState getState() {
        return state;
    }
}
