package net.sasu.lib.time.stopwatch;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for BaseStopwatch
 */
class BaseStopwatchTest {

    /**
     * Tests that getNow returns a plausible value directly after
     * starting the stopwatch
     */
    @Test
    void getNowTestAfterStart() {
        InstantSource instantSource = InstantSource.system();
        Instant instant = instantSource.instant();

        BaseStopwatch baseStopwatch = new BaseStopwatch(instantSource);
        baseStopwatch.start();

        Duration duration = Duration.between(instant, baseStopwatch.getNow());
        assertThat(duration, lessThan(Duration.of(10, ChronoUnit.MILLIS)));
    }

    /**
     * Tests that getNow returns a plausible value after
     * running the stopwatch for one second.
     */
    @Test
    void getNowTestAfterRunningOneSecond() throws InterruptedException {
        InstantSource instantSource = InstantSource.system();

        BaseStopwatch baseStopwatch = new BaseStopwatch(instantSource);
        baseStopwatch.start();
        Instant instantBeforeSleep = baseStopwatch.getNow();

        Thread.sleep(1000);
        Instant instant = instantSource.instant();

        Duration duration = Duration.between(instantBeforeSleep, instant);
        assertThat(duration, greaterThan(Duration.of(1000, ChronoUnit.MILLIS)));
    }

}