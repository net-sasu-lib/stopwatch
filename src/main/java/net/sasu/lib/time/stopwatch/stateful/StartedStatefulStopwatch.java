package net.sasu.lib.time.stopwatch.stateful;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Duration;
import java.time.Instant;

public class StartedStatefulStopwatch extends InitializedStatefulStopwatch {

    private final Instant startTime;

    public StartedStatefulStopwatch() {
        this.startTime = Instant.now();
    }

    public StartedStatefulStopwatch(Instant startTime) {
        this.startTime = startTime;
    }

    public FinishedStatefulStopwatch stop() {
        return new FinishedStatefulStopwatch(this.startTime);
    }

    public ElapsedTime getElapsedTime() {
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

}