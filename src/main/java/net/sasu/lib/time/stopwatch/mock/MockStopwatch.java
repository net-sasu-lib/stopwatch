package net.sasu.lib.time.stopwatch.mock;

import net.sasu.lib.time.elapsedTime.ElapsedTime;
import net.sasu.lib.time.stopwatch.BaseStopwatch;
import net.sasu.lib.time.stopwatch.mock.timesource.MockTimesource;

import java.time.Duration;
import java.time.Instant;

/**
 * Mock stopwatch for unit tests with ability to set specific time points.
 */
public class MockStopwatch extends BaseStopwatch<MockStopwatch> {

    private final MockTimesource instantSource;
    private Instant currentTime;

    /**
     * Creates a new MockStopwatch initialized to epoch.
     */
    public MockStopwatch() {
        super(new MockTimesource());
        this.instantSource = (MockTimesource) super.getInstantSource();
        this.currentTime = Instant.EPOCH;
    }

    /**
     * Sets the current time of the mock stopwatch.
     *
     * @param instant The time to set
     */
    public void setCurrentTime(Instant instant) {
        this.currentTime = instant;
        this.instantSource.setCurrentTime(instant);
    }

    /**
     * Increments the elapsed time by given amount of milliseconds
     * @param amount milliseconds
     */
    public void incrementMilliseconds(long amount) {
        this.currentTime = this.currentTime.plusMillis(amount);
        this.instantSource.setCurrentTime(this.currentTime);
    }

    /**
     * Increments the elapsed time by one second
     */
    public void incrementSecond() {
        this.currentTime = this.currentTime.plusSeconds(1);
        this.instantSource.setCurrentTime(this.currentTime);
    }

    /**
     * Increments the elapsed time by the given amount of seconds.
     *
     * @param seconds Amount of seconds to increment
     */
    public void incrementSeconds(long seconds) {
        this.currentTime = this.currentTime.plusSeconds(seconds);
        this.instantSource.setCurrentTime(this.currentTime);
    }

    /**
     * Gets the current mock time.
     *
     * @return the current mock time
     */
    public Instant getCurrentTime() {
        return this.currentTime;
    }

    @Override
    public ElapsedTime getElapsedTime() {
        return switch (this.getState()) {
            case INITIALIZED -> new ElapsedTime(Duration.ZERO);
            case STARTED -> new ElapsedTime(Duration.between(this.getStartTime(), this.currentTime));
            case FINISHED -> new ElapsedTime(Duration.between(this.getStartTime(), this.getStopTime()));
        };
    }
}