package net.sasu.lib.time.timesource;

import java.time.Instant;
import java.time.InstantSource;

public class MockTimesource implements InstantSource {

    private long currentTime;

    public void increment() {
        this.currentTime++;
    }

    public void increment(long amount) {
        this.currentTime+= amount;
    }

    @Override
    public Instant instant() {
        return Instant.ofEpochMilli(currentTime);
    }
}
