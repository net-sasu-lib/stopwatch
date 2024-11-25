package net.sasu.lib.time.stopwatch;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;

/**
 * Stopwatch for measuring elapsed time and outputting it in a human-readable format.
 * This is basically a "Instant factory", producing elapsed time points.
 * <p>
 * A time uses a timesource to measure time, typically at least once and saves these
 * in the class. The elapsedtimepoints can be later retrieved for further calculations
 * or displaying purposes.
 */
public interface StopwatchInterface<StopwatchType extends StopwatchInterface<StopwatchType>> {

    StopwatchType start();
    StopwatchType stop();

    Instant getStartTime();
    Instant getStopTime();

    /**
     * @return The InstantSource used by this Stopwatch
     */
    InstantSource getInstantSource();

    StopwatchState getState();

    default ElapsedTime getElapsedTime() {
        return switch (this.getState()) {
            case INITIALIZED -> new ElapsedTime(Duration.ZERO);
            case STARTED -> new ElapsedTime(getDurationUntilNow());
            case FINISHED -> new ElapsedTime(getDurationUntilStopTime());
        };
    }

    default Instant getNow(){
        return this.getInstantSource().instant();
    }

    default long getElapsedTimeNanos(){
        return this.getElapsedTime().getDuration().toNanos();
    }

    private Duration getDurationUntilNow(){
        return Duration.between(this.getStartTime(), Instant.now());
    }

    private Duration getDurationUntilStopTime(){
        return Duration.between(this.getStartTime(), this.getStopTime());
    }


}