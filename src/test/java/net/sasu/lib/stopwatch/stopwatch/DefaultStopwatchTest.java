package net.sasu.lib.stopwatch.stopwatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DefaultStopwatchTest {

    @Test
    void stopTest1() {
        DefaultStopwatch nst = new DefaultStopwatch();
        assertThrows(IllegalStateException.class, nst::stop);
    }

    @Test
    void stopTest2() {
        DefaultStopwatch nst = new DefaultStopwatch();
        nst.start();
        nst.stop();

        long maxDurationNs = 1000_000;
        long elapsedTimeRaw = nst.getElapsedTimeNanos();
        assertTrue(elapsedTimeRaw < maxDurationNs,
                "Starting and stopping should not take " + (elapsedTimeRaw) + " nanoseconds.");
    }

    @Test
    void stopTest3() {
        DefaultStopwatch nst = new DefaultStopwatch();
        nst.start();

        nst.stop();
        long elapsedTimeRaw1 = nst.getElapsedTimeNanos();

        assertTrue(true);
        long elapsedTimeRaw2 = nst.getElapsedTimeNanos();
        assertEquals(elapsedTimeRaw1, elapsedTimeRaw2);

        nst.start();
        waitAFewNanoseconds();
        long elapsedTimeRaw3 = nst.getElapsedTimeNanos();
        assertNotEquals(elapsedTimeRaw3, elapsedTimeRaw2);
    }

    @Test
    void getElapsedTimeNanosTest() {
        DefaultStopwatch nst = new DefaultStopwatch();
        assertThrows(IllegalStateException.class, nst::getElapsedTimeNanos);

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
        DefaultStopwatch nst = new DefaultStopwatch();
        nst.start();

        waitAFewNanoseconds();
        String elapsedTime = nst.stopAndGetElapsedTimeAsString();

        Thread.sleep(10);
        String elapsedTime2 = nst.getElapsedTimeAsString();
        assertEquals(elapsedTime2, elapsedTime);

        waitAFewNanoseconds();
        String elapsedTime3 = nst.getElapsedTimeAsString();
        assertEquals(elapsedTime3, elapsedTime);

        waitAFewNanoseconds();
        assertThrows(IllegalStateException.class, nst::stopAndGetElapsedTimeAsString);
    }

    /*
        Does something for at least a few nanoseconds
     */
    private void waitAFewNanoseconds(){
        double sqrt = Math.sqrt(System.currentTimeMillis());
        assertTrue(sqrt > 0); //we just want to burn CPU cycles
    }
}
