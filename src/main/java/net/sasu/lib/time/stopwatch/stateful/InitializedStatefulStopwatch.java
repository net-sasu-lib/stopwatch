package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Instant;

public class InitializedStatefulStopwatch implements StatefulStopwatch {

    private StatefulStopwatch activeInstance = this;

    public StartedStatefulStopwatch start() {
        StartedStatefulStopwatch startedStatefulStopwatch = new StartedStatefulStopwatch();
        this.activeInstance = startedStatefulStopwatch;
        return startedStatefulStopwatch;
    }

    @Override
    public boolean isFirst() {
        return true;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public StatefulStopwatch getActiveInstance() {
        if(this == this.activeInstance){
            return this.activeInstance;
        }
        return this.activeInstance.getActiveInstance();
    }

    @Override
    public StopwatchState getState() {
        return StopwatchState.INITIALIZED;
    }
}
