package net.sasu.lib.time.stopwatch;

import net.sasu.lib.time.stopwatch.state.StopwatchState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.InstantSource;

/**
 * Basic implementation of the StopwatchInterface.
 * @param <StopwatchType> The implementing class
 */
public class BaseStopwatch<StopwatchType extends StopwatchInterface<StopwatchType>> implements StopwatchInterface<StopwatchType> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    final InstantSource instantSource;
    private Instant startTime;
    private Instant stopTime;
    private StopwatchState state;

    /**
     * Creates a new BaseStopwatch in state <code>StopwatchState.INITIALIZED</code>.
     *
     * @param instantSource The InstantSource object to be used
     */
    public BaseStopwatch(InstantSource instantSource) {
        this.instantSource = instantSource;
        this.state = StopwatchState.INITIALIZED;
    }

    @Override
    public StopwatchType start() {
        if(!this.state.equals(StopwatchState.INITIALIZED)) {
            logger.warn("Attempt to start an already started stopwatch failed.");
            return (StopwatchType) this;
        }
        this.state = StopwatchState.STARTED;
        this.startTime = getNow();
        return (StopwatchType) this;
    }

    @Override
    public StopwatchType stop() {
        if(this.state.equals(StopwatchState.FINISHED)) {
            logger.warn("Attempt to stop an already finished stopwatch failed.");
            return (StopwatchType) this;
        }
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
        return this.instantSource;
    }

    @Override
    public StopwatchState getState() {
        return this.state;
    }

}
