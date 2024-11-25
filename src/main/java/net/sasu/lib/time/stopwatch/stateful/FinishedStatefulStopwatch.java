package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Duration;
import java.time.Instant;

public class FinishedStatefulStopwatch extends StartedStatefulStopwatch {

    private final Instant stopTime;

    public FinishedStatefulStopwatch(Instant startTime) {
        super(startTime);
        this.stopTime = Instant.now();
    }

    public Instant getStopTime() {
        return stopTime;
    }

    @Override
    public StopwatchState getState() {
        return StopwatchState.FINISHED;
    }

    @Override
    public ElapsedTime getElapsedTime() {
        return new ElapsedTime(getDurationUntilNow());
    }

    private Duration getDurationUntilNow(){
        return Duration.between(this.getStartTime(), this.stopTime);
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return true;
    }

    @Override
    public StatefulStopwatch getActiveInstance() {
        return this;
    }
}