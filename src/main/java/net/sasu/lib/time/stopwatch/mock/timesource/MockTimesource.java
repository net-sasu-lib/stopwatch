package net.sasu.lib.time.stopwatch.mock.timesource;

import java.time.Instant;
import java.time.InstantSource;

/**
 * Mock timesource for unit tests with support for both incremental
 * and absolute time setting.
 */
public class MockTimesource implements InstantSource {

    private long currentTime;

    /**
     * Creates a new MockTimesource initialized to epoch.
     */
    public MockTimesource() {
        super();
        this.currentTime = 0;
    }

    /**
     * Increments the elapsed time by one unit.
     */
    public void increment() {
        this.currentTime++;
    }

    /**
     * Increments the elapsed time by the given amount.
     *
     * @param amount Units of time to increment
     */
    public void increment(long amount) {
        this.currentTime += amount;
    }

    /**
     * Sets the current time to the specified instant.
     *
     * @param instant The time to set
     */
    public void setCurrentTime(Instant instant) {
        this.currentTime = instant.toEpochMilli();
    }

    /**
     * Gets the current instant of this timesource.
     *
     * @return An {@code Instant} representing the current mock time
     */
    @Override
    public Instant instant() {
        return Instant.ofEpochMilli(currentTime);
    }

    /**
     * Gets the current time in milliseconds since epoch.
     *
     * @return the current time in milliseconds
     */
    public long getCurrentTimeMillis() {
        return currentTime;
    }
}