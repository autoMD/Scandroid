// This file is protected under the KILLGPL.
// For more information, visit http://www.lukeleber.github.io/KILLGPL
//
// Copyright (c) Luke Leber <LukeLeber@gmail.com>
//
// "This software is provided freely under a single condition.  You can't force anyone
// that uses this software to release any source code.  It is their decision alone.
// Other than that, anything goes.
//
// PS. If you like this work, please hire me!  I'm uneducated (no CS degree)
// and as such its borderline impossible to get into the industry.  My current
// career is absolute hell and I am trapped in it.  I leave this message here
// in the vain hope that someone, somewhere might read this and give me the
// opportunity to join their association as a programmer."
//
// Cheers,
// Luke

package com.lukeleber.scandroid.sae.j1979;

import com.lukeleber.scandroid.util.UserFriendlyToString;

import java.io.Serializable;

/**
 * An enumeration of all possible modes that a fuel system might be in.  Each mode is comprised of a
 * loop status (that is, open or closed loop) as well as a condition that describes the
 * aforementioned loop status.  For more detailed documentation, refer to each individual enumerated
 * member.
 */
public enum FuelSystemStatus
        implements Serializable,
                   UserFriendlyToString
{
    /**
     * Open Loop: conditions have not yet been met to enter closed loop
     */
    OL(0x1, "Open Loop"),

    /**
     * Closed Loop: oxygen sensor(s) are being used as feedback for fuel metering
     */
    CL(0x2, "Closed Loop"),

    /**
     * Open Loop: driving conditions have forced open loop status (eg power enrichment or
     * deceleration enleanment)
     */
    OL_DRIVE(0x4, "Open Loop (driving conditions)"),

    /**
     * Open Loop: a system fault has prevented entry to closed loop
     */
    OL_FAULT(0x8, "Open Loop (system fault)"),

    /**
     * Closed Loop: a fault exists with at least one oxygen sensor
     */
    CL_FAULT(0x10, "Closed Loop (oxygen sensor fault)");

    /**
     * Retrieves the first status whose mask matches the provided byte
     *
     * @param byte0
     *         the byte to mask against
     *
     * @return the first status whose mask matches the provided byte or null if the masking produces
     * no matches
     */
    public static FuelSystemStatus forByte(int byte0)
    {
        for (FuelSystemStatus status : FuelSystemStatus.values())
        {
            if ((status.getMask() & byte0) != 0)
            {
                return status;
            }
        }
        return null;
    }


    /// The bit-mask of this status
    private final int mask;

    /// The user-friendly description of this status
    private final String description;

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString()
    {
        return name();
    }

    /**
     * {@inheritDoc}
     *
     */
    @Override
    public final String toUserFriendlyString()
    {
        return description;
    }

    /**
     * Constructs a FuelSystemStatus with the provided mask and description
     *
     * @param mask
     *         the bit-mask of this status
     * @param description
     *         the user-friendly description of this status
     */
    private FuelSystemStatus(int mask, String description)
    {
        this.mask = mask;
        this.description = description;
    }

    /**
     * Retrieves the bit-mask of this status
     *
     * @return the bit-mask of this status
     */
    public final int getMask()
    {
        return mask;
    }
}
