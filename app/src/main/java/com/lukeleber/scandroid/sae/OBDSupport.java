// This file is protected under the KILLGPL.
// For more information, visit http://www.lukeleber.github.io/KILLGPL.html
//
// Copyright (c) Luke Leber <LukeLeber@gmail.com>
//
// "This software is provided freely under a single condition.  You can't force anyone
// that uses this software to release any source code.  It is their decision alone.
// Other than that, anything goes.
//
// PS. If you like this work, please hire me!  I'm uneducated (no CS degree)
// and as such it's borderline impossible to get into the industry.  My current
// career is absolute hell and I am trapped in it.  I leave this message here
// in the vain hope that someone, somewhere might read this and give me the
// opportunity to join their association as a programmer."
//
// Cheers,
// Luke

package com.lukeleber.scandroid.sae;

import java.io.Serializable;

public enum OBDSupport implements Serializable
{
    UNDEFINED(0x0, "Undefined by SAE-J1979"),
    OBDII_CALIFORNIA_ARB(0x1, "OBD II"),
    OBD_FEDERAL_EPA(0x2, "OBD"),
    OBD_AND_OBDII(0x3, "OBD and OBD II"),
    OBDI(0x4, "OBD I"),
    NOT_OBD_COMPLIANT(0x5, "NO OBD"),
    EOBD(0x6, "EOBD"),
    EOBD_AND_OBDII(0x7, "EOBD and OBD II"),
    EOBD_AND_OBD(0x8, "EOBD and OBD"),
    EOBD_OBD_AND_OBDII(0x9, "EOBD, OBD, and OBD II"),
    JOBD(0xA, "JOBD"),
    JOBD_AND_OBDII(0xB, "JOBD and OBD II"),
    JOBD_AND_OBD(0xC, "JOBD and OBD"),
    JOBD_EOBD_AND_OBDII(0xD, "JOBD, EOBD, and OBD II"),
    RESERVED(0xFF, "Reserved by SAE-J1979");

    private final int val;
    private final String description;

    OBDSupport(int val, String description)
    {
        this.val = val;
        this.description = description;
    }

    public static OBDSupport forByte(int val)
    {
        if (val > values().length)
        {
            return RESERVED;
        }
        else
        {
            return values()[val];
        }
    }
}
