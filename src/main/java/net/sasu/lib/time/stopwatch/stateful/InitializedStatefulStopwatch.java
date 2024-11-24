package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Instant;

public class InitializedStatefulStopwatch implements StatefulStopwatch {

    public StartedStatefulStopwatch start() {
        return new StartedStatefulStopwatch();
    }

    @Override
    public StopwatchState getState() {
        return StopwatchState.INITIALIZED;
    }
}
