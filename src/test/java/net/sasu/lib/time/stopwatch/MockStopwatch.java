package net.sasu.lib.time.stopwatch;

import net.sasu.lib.time.timesource.MockTimesource;

/**
 * Mock time for time-independent unit tests.
 */
public class MockStopwatch extends BaseStopwatch<MockStopwatch> {

    private final MockTimesource instantSource;

    public MockStopwatch() {
        super(new MockTimesource());
        this.instantSource = (MockTimesource) super.getInstantSource();
    }

    public void increment() {
        this.instantSource.increment();
    }

    public void increment(long amount) {
        this.instantSource.increment(amount);
    }
}
