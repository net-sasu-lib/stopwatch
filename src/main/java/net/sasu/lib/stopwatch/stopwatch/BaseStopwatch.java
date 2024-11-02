package net.sasu.lib.stopwatch.stopwatch;

import java.time.Instant;
import java.time.InstantSource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Measures passage of time using the given time source, or if none
 * given, SystemMilliSecondInstantSource as default.
 * <p>
 * Typically used followingly:
 * <p>
 * 1) Create instance and start stopwatch with DefaultStopwatch.getInstanceAndStart()
 * 2) Stop stopwatch and get elapsed time as string with
 * stopwatch.getElapsedTimeAndStop()
 *
 * @author Sasu
 */
public class BaseStopwatch<StopwatchType extends Stopwatch<StopwatchType>> implements Stopwatch<StopwatchType> {

    final InstantSource instantSource;
    final List<Instant> allTimePoints = new ArrayList<>();
    private boolean running = false;

    public BaseStopwatch(InstantSource instantSource) {
        this.instantSource = instantSource;
    }

    /**
     * @param instantSource
     * @param outputter
     */
    public BaseStopwatch(InstantSource instantSource, Consumer<String> outputter) {
        this.instantSource = instantSource;
    }

    @Override
    public List<Instant> getAllTimePoints() {
        return allTimePoints;
    }

    @Override
    public InstantSource getInstantSource() {
        return instantSource;
    }

    @Override
    public Instant getInstant() {
        return this.instantSource.instant();
    }

    @Override
    public boolean isRunning() {
        return this.running;
    }

    @Override
    public StopwatchType start() {
        this.running = true;
        return this.saveCurrentTime();
    }

    @Override
    public StopwatchType stop() {
        if (!isRunning()) {
            throw new IllegalStateException("Stopwatch is not running");
        }
        this.running = false;
        return this.saveCurrentTime();
    }

    @Override
    public StopwatchType saveCurrentTime() {
        var elapsedTimePoint = createNewInstant();
        this.getAllTimePoints().add(elapsedTimePoint);
        return (StopwatchType) this;
    }

    private Instant createNewInstant() {
        return getInstantSource().instant();
    }

}
