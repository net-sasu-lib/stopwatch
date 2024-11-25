package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Duration;
import java.time.Instant;

public class StartedStatefulStopwatch extends InitializedStatefulStopwatch {

    private final Instant startTime;
    private StatefulStopwatch activeInstance = this;

    public StartedStatefulStopwatch() {
        this.startTime = Instant.now();
    }

    public StartedStatefulStopwatch(Instant startTime) {
        this.startTime = startTime;
    }

    public FinishedStatefulStopwatch stop() {
        FinishedStatefulStopwatch finishedStatefulStopwatch = new FinishedStatefulStopwatch(this.startTime);
        this.activeInstance = finishedStatefulStopwatch;
        return finishedStatefulStopwatch;
    }

    public ElapsedTime getElapsedTime() {
        return this.getActiveInstance().get
    }

    ElapsedTime getElapsedTimeForInstance() {
        return new ElapsedTime(getDurationUntilNow());
    }

    public Instant getStartTime() {
        return startTime;
    }

    @Override
    public StopwatchState getState() {
        return StopwatchState.STARTED;
    }

    private Duration getDurationUntilNow() {
        return Duration.between(this.startTime, Instant.now());
    }

    @Override
    public boolean isFirst() {
        return false;
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
}