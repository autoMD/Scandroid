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

/**
 * <p>Implementation details for the ELM327 can be found within this package.  Refer to the
 * {@link com.lukeleber.scandroid.interpreter.elm327.OpCode} class for more detailed information as
 * to how to configure the ELM327 for use.</p>
 *
 * <p>Otherwise, using the ELM327 implementation is very simple:
 * <pre>
 *     /// arbitrary communication interface
 *     CommunicationInterface comm = ...;
 *
 *     /// single constructor
 *     ELM327 elm = new ELM327(comm);
 *
 *     /// asynchronously start the interpreter
 *     elm.start();
 *
 *     /// start talking with a vehicle
 *     elm.sendRequest(...);
 * </pre></p>
 *
 */
package com.lukeleber.scandroid.interpreter.elm327;