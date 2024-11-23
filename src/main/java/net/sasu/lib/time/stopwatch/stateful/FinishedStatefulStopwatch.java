package net.sasu.lib.time.stopwatch.stateful;

import java.time.Duration;
import java.time.Instant;

public class FinishedStatefulStopwatch extends StartedStatefulStopwatch {

    private final Instant stopTime;

    public FinishedStatefulStopwatch() {
        this.stopTime = Instant.now();
    }

    public Duration getElapsedTime(){
        return Duration.between(this.getStartTime(), this.stopTime);
    }

    public Instant getStopTime() {
        return stopTime;
    }
}