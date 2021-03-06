/*
 * Lokomo OneCMDB - An Open Source Software for Configuration
 * Management of Datacenter Resources
 *
 * Copyright (C) 2006 Lokomo Systems AB
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 * 
 * Lokomo Systems AB can be contacted via e-mail: info@lokomo.com or via
 * paper mail: Lokomo Systems AB, Sv�rdv�gen 27, SE-182 33
 * Danderyd, Sweden.
 *
 */
package org.onecmdb.dto;

import java.io.Serializable;
import java.util.UUID;


/**
 * Class containg key values, which are universily unique. From this
 * <em>longHash</em>, one may extract creation and modifaction timestamps.
 */
public class ItemId implements Serializable, Comparable {
    public static final String NAMESPACE  = "oneCMDB:#";

    private static final long serialVersionUID = 98836700497597228L;
    private final long longHash;
    private String delegate;

    /**
     * Constructs a new, unique, identifier
     */
    public ItemId() {
        UUID uuid = UUID.randomUUID();
        this.longHash = uuid.getMostSignificantBits() ^
                uuid.getLeastSignificantBits();

        this.delegate = uuid.toString();
    }

    /**
     * Recreate the identifier using the known <em>longHash</em>
     *
     * @param longHash
     */
    public ItemId(long hash) {
        this.longHash = hash;
    }

    /**
     * Recreate the identifier using the lexical string representation of item.
     *
     * @param text
     * @see #toString
     */
    public ItemId(final String text) {
        String idStr = text;
        if (text.indexOf(NAMESPACE)>-1){
            idStr = text.replace(NAMESPACE, "");
        }
        this.longHash = Long.parseLong(idStr);
    }

    public long asLong() {
        return (this.longHash);
    }

    @Override
    public int hashCode() {
        return new Long(this.longHash).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass()))
            return false;

        ItemId other = (ItemId) obj;
        return this.longHash == other.longHash;
    }

    public int compareTo(Object o) {
        if (o == null)
            return 1;
        if (!getClass().equals(o))
            return 1;

        ItemId other = (ItemId) o;
        if (this.longHash < other.longHash)
            return -1;
        if (this.longHash == other.longHash)
            return 0;
        return 1;
    }

    /**
     * <p>Produces the lexical string representation of this identifier, which
     * is the hex string (lower case) of the internal longHash.</p>
     * <p>
     * <p>This string you can use for <em>serializating</em> the indentifier
     * and later reconstruct it using the {@link #ItemId(String)} constructor.
     */
    public String toString() {
        String s = Long.toHexString(longHash);
        return s;
    }

    public Object getDelegate() {
        return this.delegate;
    }
}
