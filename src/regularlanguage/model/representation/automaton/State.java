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

import static regularlanguage.util.Util.*;

/**
 * A state of an automaton.
 *
 * @author Felix Wiemuth
 */
public abstract class State {

    private static int nextID = 0;
    private String name;

    /**
     * Create a new state.
     *
     * @param name
     */
    public State(String name) {
        this.name = name;
        debugLog("Created new State " + name);
    }

    /**
     * Create a new state. It is named by a unique number, starting at zero and
     * increased for each instantiation of this class.
     */
    public State() {
        this("" + nextID++);
    }

    public String getName() {
        return name;
    }
}
