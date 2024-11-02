package net.sasu.lib.time.stopwatch;

import java.time.InstantSource;

/**
 * Measures passage of time using the given time source, or if none
 * given, SystemMilliSecondInstantSource as default. 
 * <p>
 * Typically used followingly:
 * <p>
 * 1) Create instance and start time with DefaultStopwatch.getInstanceAndStart()
 * 2) Stop time and get elapsed time as string with
 * time.getElapsedTimeAndStop()
 *  
 * @author Sasu
 *
 */
public class DefaultStopwatch
		extends BaseStopwatch<DefaultStopwatch> {

	public DefaultStopwatch() {
		super(InstantSource.system());
	}

}
