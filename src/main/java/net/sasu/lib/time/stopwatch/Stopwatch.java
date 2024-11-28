package net.sasu.lib.time.stopwatch;

import java.time.InstantSource;

/**
 * Basic stopwatch with three possible states:
 * initialized, started and finished. The stopwatch can be
 * started and stopped once. After being started the
 * elapsed time can be retrieved.
 */
public class Stopwatch extends BaseStopwatch<Stopwatch>{

    /**
     * Creates a new Stopwatch in state <code>StopwatchState.INITIALIZED</code>.
     */
    public Stopwatch() {
        super(InstantSource.system());
    }

    /**
     * Creates a new Stopwatch
     *
     * @return a new Stopwatch in state <code>StopwatchState.INITIALIZED</code>.
     */
    public static Stopwatch create() {
        return new Stopwatch();
    }

}
