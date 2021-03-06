// This file is protected under the KILLGPL.
// For more information, visit http://www.lukeleber.github.io/KILLGPL.html
//
// Copyright (c) Luke Leber <LukeLeber@gmail.com>

package com.lukeleber.scandroid.sae.j1979;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * This implementation was created from the information provided through Table A1 of Appendix A of
 * the SAE-J1979 document.
 * <p/>
 * SAE-J1979 supports querying the PIDs supported by a vehicle in ranges of 32 boolean fields where
 * the last field in the range represents whether or not additional support ranges exist for a
 * provided vehicle.  This class encapsulates this support with an easy to use interface that allows
 * querying individual PIDs as well as providing a more advanced way to reap lower level efficiency
 * should it be needed.
 *
 * @see android.os.Parcelable
 * @see java.io.Serializable
 */
public final class PIDSupport
        implements Serializable,
                   Parcelable
{

    /// Required by the {@link android.os.Parcelable} interface
    public final static Creator<PIDSupport> CREATOR
            = new Creator<PIDSupport>()
    {
        /**
         * {@inheritDoc}
         */
        @Override
        public final PIDSupport createFromParcel(Parcel in)
        {
            return new PIDSupport(in.readInt());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public final PIDSupport[] newArray(int length)
        {
            return new PIDSupport[length];
        }
    };

    /// The 32-bits that make up this range of PID support
    private final int bits;

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents()
    {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeInt(bits);
    }

    /**
     * Constructs a <code>PIDSupport</code> from the provided 32-bit integer
     *
     * @param bits
     *         the 32-bit integer that represents a bit-stream.
     */
    public PIDSupport(int bits)
    {
        this.bits = bits;
    }

    /**
     * Is the provided PID supported? <p> It is worth noting that this method will perform the
     * following conversion on the <i>pid</i> argument to ensure a proper value for this range:
     * <pre>
     *         pid %= 32;
     *     </pre>
     * Therefore it is feasible to feed this method semantically incorrect inputs and retrieve a
     * valid result.  For example, if this PIDSupport represents support checking for PIDs 1 to 32
     * and the provided <i>pid</i> argument is 33, while 33 is semantically out of range, it is
     * shifted into range and the result (33 % 32 = 1) is used in the calculation. </p>
     *
     * @param pid
     *         the PID (in the range [1, 254]) to check support for
     *
     * @return true if the provided PID is supported, otherwise false
     *
     * @throws IllegalArgumentException
     *         if provided PID lies outside of the range [1, 254] <p><i> Fun fact: PID 0 is required
     *         and guaranteed to be supported in all circumstances whereas PID 255 is reserved by
     *         the standard and is (currently) required to be unsupported in all circumstances. <p/>
     *         </i></p>
     */
    public boolean checkSupport(int pid)
    {
        if (pid < 0x0 || pid > 0xFF)
        {
            throw new IllegalArgumentException("Only PIDs from 1 to 255 are supported");
        }
        return (bits & (1 << (32 - (pid % 32)))) != 0;
    }

    /**
     * Retrieves the internal bit-set representation of this <code>PIDSupport</code>. <p>To
     * illustrate:
     * <pre>
     *     int bitset = 0b01010101010101010101010101010101;
     *     PID 1 sup? = __|||| ...                       |
     *     PID 2 sup? = ___||| ...                       |
     *     PID 3 sup? = ____|| ...                       |
     *     PID 4 sup? = _____| ...                       |
     *     ...                                           |
     *     ...                                           |
     *     PID 32 sup? = ________________________________|
     * </pre>
     * </p>
     *
     * @return the internal bit-set representation of this <code>PIDSupport</code>
     */
    public int getBits()
    {
        return bits;
    }
}
