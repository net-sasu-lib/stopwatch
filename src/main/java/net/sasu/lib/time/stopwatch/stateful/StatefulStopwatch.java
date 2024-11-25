package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.stopwatch.state.StopwatchState;

/**
 * Marker interface
 */
public interface StatefulStopwatch {

    boolean isFirst();
    boolean isLast();

    StatefulStopwatch getActiveInstance();

    StopwatchState getState();
}
