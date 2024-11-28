package net.sasu.lib.time.stopwatch;

import net.sasu.lib.time.elapsedTime.ElapsedTime;

import java.util.function.Consumer;

/**
 * Static stopwatch for simple use cases, where parallel execution
 * of multiple stopwatch is not necessary.
 */
public class StaticStopwatch {

    private static Stopwatch stopwatch = null;

    /**
     * Constructor to prevent non-static construction
     *
     * @throws IllegalAccessException always
     */
    private StaticStopwatch() throws IllegalAccessException {
        throw new IllegalAccessException("Static use only");
    }

    /**
     * Creates a new static stopwatch and starts it.
     * @see Stopwatch#start()
     */
    public static void start(){
        stopwatch = new Stopwatch();
        stopwatch.start();
    }

    /**
     * Stops the static stopwatch.
     * @return StaticStopwatch
     * @see Stopwatch#stop()
     */
    public StaticStopwatch stop(){
        stopwatch.stop();
        return this;
    }

    /**
     * Stops the stopwatch and prints the output to stdout
     * in format HH:mm:ss.SSS. Example: "00:00:01.111"
     *
     * @see Stopwatch#stop()
     * @see ElapsedTime#println()
     */
    public static void stopAndPrint(){
        stopAndPrint(System.out::println);
    }

    /**
     * Stops the stopwatch and prints the output to stdout
     * in format HH:mm:ss.SSS, prepending the output with the given
     * string. For example, if the method is called with the string
     * "Time: ", the output is "Time: 00:00:01.111"
     *
     * @param prepender String to prepend before printing time
     *
     * @see Stopwatch#stop()
     * @see ElapsedTime#println()
     */
    public static void stopAndPrint(String prepender){
        stopAndPrint(prepender, System.out::println);
    }

    /**
     * Stops the stopwatch and passes the output to the given function
     * in format HH:mm:ss.SSS, e.g. "00:00:01.111".
     *
     * @param printTarget Function which is applied to the elapsed time string
     *
     * @see Stopwatch#stop()
     * @see ElapsedTime#println()
     */
    public static void stopAndPrint(Consumer<String> printTarget){
        stopwatch.stop();
        stopwatch.getElapsedTime().printTo(printTarget);

    }

    /**
     * Stops the stopwatch and passes the output to the given function
     * in format HH:mm:ss.SSS, prepending the output with the given
     * string. For example, if the method is called with the string
     * "Time: ", the output passed on would be "Time: 00:00:01.111"
     *
     * @param prepender String to prepend before printing time
     * @param printTarget Function which is applied to the elapsed time string
     *
     * @see Stopwatch#stop()
     * @see ElapsedTime#println()
     */
    public static void stopAndPrint(String prepender, Consumer<String> printTarget){
        stopwatch.stop();
        String formattedElapsedTime = stopwatch.getElapsedTime().getFormattedOutput();
        String output = prepender + formattedElapsedTime;
        printTarget.accept(output);
    }

    /**
     * Returns the elapsed time of the stopwatch.
     *
     * @return ElapsedTime object
     * @see Stopwatch#getElapsedTime()
     */
    public static ElapsedTime getElapsedTime(){
        return stopwatch.getElapsedTime();
    }
}
