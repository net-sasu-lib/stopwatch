package net.sasu.lib.stopwatch.stopwatch;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import java.util.List;

/**
 * Stopwatch for measuring elapsed time and outputting it in a human-readable format.
 * This is basically a "Instant factory", producing elapsed time points.
 * <p>
 * A stopwatch uses a timesource to measure time, typically at least once and saves these
 * in the class. The elapsedtimepoints can be later retrieved for further calculations
 * or displaying purposes.
 */
public interface Stopwatch<StopwatchType extends Stopwatch<StopwatchType>> {

    /**
     * Starts stopwatch
     */
    /*

    default StopwatchType start() {
        return this.saveCurrentTime();
    }
     */

    /*
    default StopwatchType saveCurrentTime() {
        var elapsedTimePoint = createNewInstant();
        this.getAllTimePoints().add(elapsedTimePoint);
        return this;
    }
    */

    /**
     * Stops stopwatch
     */
    /*
    default StopwatchType stop() {
        if (!isRunning()) {
            throw new IllegalStateException("Stopwatch is not running");
        }
        return this.saveCurrentTime();
    }
    */

    StopwatchType start();
    StopwatchType stop();
    StopwatchType saveCurrentTime();

    /**
     * @return The InstantSource used by this Stopwatch
     */
    InstantSource getInstantSource();

    Instant getInstant();

    boolean isRunning();

    default Instant getStartTime() {
        if (getAllTimePoints().isEmpty()) {
            throw new IllegalStateException("Has not been started yet.");
        }
        return getAllTimePoints().get(0);
    }

    default Instant getLatestTime() {
        return getAllTimePoints().get(getAllTimePoints().size() - 1);
    }

    List<Instant> getAllTimePoints();

    /**
     * @return elapsed time in the base time units defined by this stopwatch implementation
     */
    default long getElapsedTimeNanos() {
        if (hasNotBeenStarted()) {
            throw new IllegalStateException("Has not been started yet.");
        }
        return getElapsedTime().getNano();
    }

    /**
     * @return Elapsed time
     */
    default Duration getElapsedTime() {
        if (hasNotBeenStarted()) {
            throw new IllegalStateException("Has not been started yet.");
        }

        Instant endTime = isRunning() ? getInstant() : getLatestTime();
        return Duration.between(getStartTime(), endTime);
    }


    default String getElapsedTimeAsString() {
        Duration elapsedTime = getElapsedTime();
        return DurationFormatUtils.formatDuration(elapsedTime.toMillis(), "HH'hrs' mm'mins' ss'sec'");
    }

    default boolean hasNotBeenStarted() {
        return this.getAllTimePoints().isEmpty();
    }

    default String stopAndGetElapsedTimeAsString() {
        stop();
        return getElapsedTimeAsString();
    }

}