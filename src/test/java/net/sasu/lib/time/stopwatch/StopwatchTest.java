package net.sasu.lib.time.stopwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for Stopwatch class.
 */
class StopwatchTest {

    /**
     * Tests that elapsed time after starting and stopping the stopwatch
     * is reasonably short.
     */
    @Test
    void stopTestStopPerformance() {
        Stopwatch nst = new Stopwatch();
        nst.start();
        nst.stop();

        long maxDurationNs = 1000_000;
        long elapsedTimeRaw = nst.getElapsedTime().getDuration().toNanos();
        assertTrue(elapsedTimeRaw < maxDurationNs,
                "Starting and stopping should not take " + (elapsedTimeRaw) + " nanoseconds.");
    }


    /**
     * Tests that getElapsedTimeNanos returns always the same
     * value when stopwatch is stopped.
     */
    @Test
    void getElapsedTimeNanosTestStateAdherence() {
        Stopwatch nst = new Stopwatch();
        nst.start();
        nst.stop();

        long elapsedTimeRaw1 = nst.getElapsedTimeNanos();
        long elapsedTimeRaw2 = nst.getElapsedTimeNanos();
        assertEquals(elapsedTimeRaw1, elapsedTimeRaw2);
        waitAFewNanoseconds();
        long elapsedTimeRaw3 = nst.getElapsedTimeNanos();
        assertEquals(elapsedTimeRaw2, elapsedTimeRaw3);
    }


    /**
     * Tests that elapsed time as returned by getElapsedTimeNanos
     * does not increase after attempting to re-start an already
     * stopped stopwatch.
     */
    @Test
    void stopTestElapsedTimeAfterFailedAttemptToStart() {
        Stopwatch nst = new Stopwatch();
        nst.start();
        nst.stop();

        long elapsedTimeRaw1 = nst.getElapsedTimeNanos();
        nst.start();
        waitAFewNanoseconds();
        long elapsedTimeRaw2 = nst.getElapsedTimeNanos();
        assertEquals(elapsedTimeRaw1, elapsedTimeRaw2);
    }

    @Test
    void getElapsedTimeNanosTest() {
        Stopwatch nst = new Stopwatch();
        nst.start();
        waitAFewNanoseconds();
        long elapsedTimeRaw1 = nst.getElapsedTimeNanos();
        assertTrue(elapsedTimeRaw1 > 0, "elapsedTimeRaw1: " + elapsedTimeRaw1);

        waitAFewNanoseconds();
        nst.stop();
        long elapsedTimeRaw2 = nst.getElapsedTimeNanos();
        assertTrue(elapsedTimeRaw2 > elapsedTimeRaw1, "elapsedTimeRaw1: " +
                elapsedTimeRaw1 + ", elapsedTimeRaw2: " + elapsedTimeRaw2);

        long elapsedTimeRaw3 = nst.getElapsedTimeNanos();
        assertEquals(elapsedTimeRaw2, elapsedTimeRaw3);
    }

    @Test
    void stopAndGetElapsedTimeAsStringTest() throws InterruptedException {
        Stopwatch nst = new Stopwatch();
        nst.start();

        waitAFewNanoseconds();
        nst.stop();
        String elapsedTime = nst.getElapsedTime().toString();

        Thread.sleep(10);
        nst.stop();
        String elapsedTime2 = nst.getElapsedTime().toString();
        assertEquals(elapsedTime2, elapsedTime);

        waitAFewNanoseconds();
        String elapsedTime3 = nst.getElapsedTime().toString();
        assertEquals(elapsedTime3, elapsedTime);
    }

    /*
        Does something for at least a few nanoseconds
     */
    private void waitAFewNanoseconds(){
        double sqrt = Math.sqrt(System.currentTimeMillis());
        assertTrue(sqrt > 0); //we just want to burn CPU cycles
    }
}
