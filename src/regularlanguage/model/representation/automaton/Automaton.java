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
package regularlanguage.model.representation.automaton;

import java.util.Set;
import regularlanguage.model.RepresentationCollection;
import regularlanguage.model.representation.RegularLanguage;

/**
 * An abstract representation of an automaton which represents a regular
 * language.
 *
 * @author Felix Wiemuth
 */
public abstract class Automaton extends RegularLanguage {

    private String name;

    public Automaton(String name) {
        super();
        this.name = name;
    }

    public Automaton(String name, RepresentationCollection representations) {
        super(representations);
        this.name = name;
    }

    /**
     * Checks whether this object represents the formal automaton of the
     * implementation.
     *
     * @return
     */
    public abstract boolean satisfiesDefintion();

    /**
     * Check whether a word is accepted by this automaton. This is equivalent to
     * 'contains()'.
     *
     * @param wordIterator Iterator initialized to the beginning of the word
     * @return
     */
    public abstract boolean accepts(Iterable<Object> word);

    @Override
    public boolean contains(Iterable<Object> wordIterator) {
        return accepts(wordIterator);
    }

    public abstract Set<State> getStates();

    public String getName() {
        return name;
    }
}
