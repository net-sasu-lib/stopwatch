package net.sasu.lib.time.stopwatch;

import net.sasu.lib.time.stopwatch.state.StopwatchState;

import java.time.Instant;
import java.time.InstantSource;

public class BaseStopwatch<StopwatchType extends StopwatchInterface<StopwatchType>> implements StopwatchInterface<StopwatchType> {

    final InstantSource instantSource;
    private Instant startTime;
    private Instant stopTime;
    private StopwatchState state;

    public BaseStopwatch(InstantSource instantSource) {
        this.instantSource = instantSource;
        this.state = StopwatchState.INITIALIZED;
    }

    @Override
    public StopwatchType start() {
        this.state = StopwatchState.STARTED;
        this.startTime = getNow();
        return (StopwatchType) this;
    }

    @Override
    public StopwatchType stop() {
        this.state = StopwatchState.FINISHED;
        this.stopTime = getNow();
        return (StopwatchType) this;
    }

    @Override
    public Instant getStartTime() {
        return this.startTime;
    }

    @Override
    public Instant getStopTime() {
        return this.stopTime;
    }

    @Override
    public InstantSource getInstantSource() {
        return InstantSource.system();
    }

    @Override
    public StopwatchState getState() {
        return this.state;
    }

}
