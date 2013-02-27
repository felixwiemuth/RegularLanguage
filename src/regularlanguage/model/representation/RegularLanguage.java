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
package regularlanguage.model.representation;

import regularlanguage.model.RepresentationCollection;

/**
 * An abstract representation of a regular language.
 *
 * @author Felix Wiemuth
 */
public abstract class RegularLanguage {

    private RepresentationCollection representations;

    /**
     * Create a new representation of a regular language.
     * A new representation collection is created.
     */
    public RegularLanguage() {
        representations = new RepresentationCollection();
    }

    /**
     * Create a new representation of a regular language, using an existing representation collection.
     * @param representations the representation collection for this language to be used
     */
    public RegularLanguage(RepresentationCollection representations) {
        this.representations = representations;
    }

    /**
     * Check whether a word is contained in the language, using the underlying
     * representation model.
     *
     * @param wordIterator Iterator initialized to the beginning of the word
     * @return
     */
    public abstract boolean contains(Iterable<Object> wordIterator);
    
    /**
     * Get the associated representation collection for this language.
     * @return 
     */
    protected RepresentationCollection representations() {
        return representations;
    }
}
