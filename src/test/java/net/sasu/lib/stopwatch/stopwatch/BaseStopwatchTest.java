package net.sasu.lib.stopwatch.stopwatch;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.InstantSource;
import java.time.temporal.ChronoUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class BaseStopwatchTest {

    @Test
    void getInstantTest1() {
        InstantSource instantSource = InstantSource.system();
        Instant instant = instantSource.instant();

        BaseStopwatch baseStopwatch = new BaseStopwatch(instantSource);
        baseStopwatch.start();

        Duration duration = Duration.between(instant, baseStopwatch.getInstant());
        assertThat(duration, lessThan(Duration.of(10, ChronoUnit.MILLIS)));
    }

    @Test
    void getInstantTest2() throws InterruptedException {
        InstantSource instantSource = InstantSource.system();

        BaseStopwatch baseStopwatch = new BaseStopwatch(instantSource);
        baseStopwatch.start();
        Instant instantBeforeSleep = baseStopwatch.getInstant();

        Thread.sleep(1000);
        Instant instant = instantSource.instant();

        Duration duration = Duration.between(instantBeforeSleep, instant);
        assertThat(duration, greaterThan(Duration.of(1000, ChronoUnit.MILLIS)));
    }

}