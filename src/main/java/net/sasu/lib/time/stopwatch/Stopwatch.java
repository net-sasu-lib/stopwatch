package net.sasu.lib.time.stopwatch;

import java.time.InstantSource;

/**
 * Basic stopwatch using default System InstantSource
 */
public class Stopwatch extends BaseStopwatch<Stopwatch>{

    /**
     * Creates a new Stopwatch
     */
    public Stopwatch() {
        super(InstantSource.system());
    }
}
