package net.sasu.lib.time.stopwatch.mock;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.BaseStopwatch;
import net.sasu.lib.time.stopwatch.mock.timesource.MockTimesource;

import java.time.Duration;
import java.time.Instant;

/**
 * Mock time for unit tests.
 */
public class MockStopwatch extends BaseStopwatch<MockStopwatch> {

    private final MockTimesource instantSource;

    /**
     * Creates a new MockStopwatch
     */
    public MockStopwatch() {
        super(new MockTimesource());
        this.instantSource = (MockTimesource) super.getInstantSource();
    }

    /**
     * Increments the elapsed time by one unit
     */
    public void increment() {
        this.instantSource.increment();
    }

    /**
     * Increments the elapsed time by the given amount
     * @param amount Units of time to increment
     */
    public void increment(long amount) {
        this.instantSource.increment(amount);
    }

    /**
     * Calculates and retrieves the elapsed time as an {@link ElapsedTime} object.
     * <p>
     * The result depends on the current state of the stopwatch:
     * <ul>
     *     <li>If {@code INITIALIZED}, the elapsed time is zero.</li>
     *     <li>If {@code STARTED}, the elapsed time is calculated up to the current time.</li>
     *     <li>If {@code FINISHED}, the elapsed time is calculated from the start to the stop time.</li>
     * </ul>
     *
     * @return an {@link ElapsedTime} object representing the elapsed time
     */
    public ElapsedTime getElapsedTime() {
        return switch (this.getState()) {
            case INITIALIZED -> new ElapsedTime(Duration.ZERO);
            case STARTED, FINISHED -> new ElapsedTime(getDurationUntilMockNow());
        };
    }

    private Duration getDurationUntilMockNow() {
        return Duration.between(Instant.EPOCH, this.getNow());
    }

}
