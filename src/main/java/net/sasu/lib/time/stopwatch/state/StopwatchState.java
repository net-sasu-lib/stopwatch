package net.sasu.lib.time.stopwatch.state;

/**
 * Represents the possible states of a stopwatch during its lifecycle.
 */
public enum StopwatchState {

    /**
     * The stopwatch has been initialized but has not been started yet.
     * No time measurements have been recorded.
     */
    INITIALIZED,

    /**
     * The stopwatch is currently running.
     * The start time has been recorded, but the stop time has not.
     */
    STARTED,

    /**
     * The stopwatch has been stopped.
     * Both the start time and stop time have been recorded.
     */
    FINISHED
}
