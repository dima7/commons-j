// Copyright 2010 Nathaniel Harward
//
// This file is part of ndh-commons.
//
// ndh-commons is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// ndh-commons is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with ndh-commons. If not, see <http://www.gnu.org/licenses/>.

package us.harward.commons.util;

import static us.harward.commons.util.Equals.allowNull;

/**
 * A 4-tuple, when returning 4 values is more convenient than creating a special class. Null values are allowed for any/all
 * positions of the tuple.
 */
public class Quadruple<T1, T2, T3, T4> {

    private final T1 first;
    private final T2 second;
    private final T3 third;
    private final T4 fourth;

    public Quadruple(final T1 first, final T2 second, final T3 third, final T4 fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }

    public T1 first() {
        return first;
    }

    public T2 second() {
        return second;
    }

    public T3 third() {
        return third;
    }

    public T4 fourth() {
        return fourth;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj instanceof Quadruple<?, ?, ?, ?>) {
            final Quadruple<?, ?, ?, ?> other = (Quadruple<?, ?, ?, ?>) obj;
            return allowNull(first(), other.first()) && allowNull(second(), other.second()) && allowNull(third(), other.third())
                    && allowNull(fourth(), other.fourth());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((second == null) ? 0 : second.hashCode());
        result = prime * result + ((third == null) ? 0 : third.hashCode());
        result = prime * result + ((fourth == null) ? 0 : fourth.hashCode());
        return result;
    }

}
