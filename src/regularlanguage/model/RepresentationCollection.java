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
package regularlanguage.model;

import regularlanguage.model.representation.automaton.dfa.DFA;
import regularlanguage.model.representation.automaton.nfa.NFA;

/**
 * Collects different representations for one regular Language.
 *
 * @author Felix Wiemuth
 */
public class RepresentationCollection {

    private NFA nfa;
    private DFA dfa;

    public NFA getNFA() {
        return nfa;
    }

    public DFA getDFA() {
        return dfa;
    }

    public void setNFA(NFA nfa) {
        this.nfa = nfa;
    }

    public void setDFA(DFA dfa) {
        this.dfa = dfa;
    }
}
