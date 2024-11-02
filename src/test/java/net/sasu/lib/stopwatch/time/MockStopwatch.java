package net.sasu.lib.stopwatch.time;

import net.sasu.lib.stopwatch.stopwatch.BaseStopwatch;
import net.sasu.lib.stopwatch.timesource.MockTimesource;

/**
 * Mock stopwatch for time-independent unit tests.
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
