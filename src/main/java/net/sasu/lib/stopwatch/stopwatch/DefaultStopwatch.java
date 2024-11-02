package net.sasu.lib.stopwatch.stopwatch;

import java.time.InstantSource;

/**
 * Measures passage of time using the given time source, or if none
 * given, SystemMilliSecondInstantSource as default. 
 * <p>
 * Typically used followingly:
 * <p>
 * 1) Create instance and start stopwatch with DefaultStopwatch.getInstanceAndStart()
 * 2) Stop stopwatch and get elapsed time as string with
 * stopwatch.getElapsedTimeAndStop()
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
