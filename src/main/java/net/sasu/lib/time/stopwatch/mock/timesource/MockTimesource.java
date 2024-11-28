package net.sasu.lib.time.stopwatch.mock.timesource;

import java.time.Instant;
import java.time.InstantSource;

/**
 * Mock timesource for unit tests.
 */
public class MockTimesource implements InstantSource {

    private long currentTime;

    /**
     * Creates a new MockTimesource.
     */
    public MockTimesource() {
        super();
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
        this.currentTime+= amount;
    }

    /**
     * Gets the current instant of this timesource.
     *
     * @return An <code>Instant</code>
     */
    @Override
    public Instant instant() {
        return Instant.ofEpochMilli(currentTime);
    }
}
