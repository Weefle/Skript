/*
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * Copyright 2011-2013 Peter G�ttinger
 * 
 */

package ch.njol.util;

import javax.annotation.Nullable;

/**
 * @author Peter G�ttinger
 *
 */
public class SynchronizedReference<V>
{
  @Nullable
  private volatile V value;
  
  public SynchronizedReference(@Nullable V initialValue)
  {
    this.value = initialValue;
  }
  
  @SuppressWarnings("null")
  public SynchronizedReference() {}
  
  @Nullable
  public final V get()
  {
    assert (Thread.holdsLock(this));
    return this.value;
  }
  
  public final void set(@Nullable V newValue)
  {
    assert (Thread.holdsLock(this));
    this.value = newValue;
  }
}