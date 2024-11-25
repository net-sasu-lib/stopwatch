package net.sasu.lib.time.stopwatch;

import java.time.InstantSource;

public class Stopwatch extends BaseStopwatch<Stopwatch>{

    public Stopwatch() {
        super(InstantSource.system());
    }
}
