package net.sasu.lib.time.stopwatch.stateful;

import java.time.Duration;
import java.time.Instant;

public class StartedStatefulStopwatch extends InitializedStatefulStopwatch {

    private final Instant startTime;

    public StartedStatefulStopwatch() {
        this.startTime = Instant.now();
    }

    public FinishedStatefulStopwatch stop(){
        return new FinishedStatefulStopwatch();
    }

    public Duration getElapsedTime(){
        return Duration.between(this.startTime, Instant.now());
    }

    public Instant getStartTime() {
        return startTime;
    }
}