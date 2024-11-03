package net.sasu.lib.time.output;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Represents an abstract output source with customizable formatting.
 * Provides methods for setting a formatter and outputting the formatted
 * string to various targets.
 *
 * @param <OutputSourceType> the specific type extending this class
 */
public abstract class OutputSource<OutputSourceType extends OutputSource<OutputSourceType>> {

    private final OutputSourceType outputSourceType;
    private Function<OutputSourceType, String> formatter = Object::toString;

    /**
     * Constructs an {@code OutputSource} and sets the type token to the
     * specific type of the extending class (for type-safe return types).
     *
     * @param typeToken the class of the extending type
     */
    protected OutputSource(Class<OutputSourceType> typeToken) {
        this.outputSourceType = typeToken.cast(this);
    }

    /**
     * Returns the instance of the extending class.
     *
     * @return the current instance cast to {@code OutputSourceType}
     */
    public OutputSourceType getOutput() {
        return outputSourceType;
    }

    /**
     * Returns the formatted output string as defined by the current formatter.
     *
     * @return the formatted output string
     */
    public String getFormattedOutput() {
        return this.formatter.apply(getOutput());
    }

    /**
     * Sets a custom formatter for the output and returns the instance.
     *
     * @param outputFormatter a function that takes an instance of {@code OutputSourceType}
     *                        and returns a formatted string
     * @return the current instance of {@code OutputSourceType}
     */
    public OutputSourceType format(Function<OutputSourceType, String> outputFormatter) {
        this.formatter = outputFormatter;
        return this.outputSourceType;
    }

    /**
     * Prints the formatted output to {@code System.out}.
     */
    public void println() {
        System.out.println(getFormattedOutput());
    }

    /**
     * Sends the formatted output to the specified consumer function.
     *
     * @param printTargetMethod a {@link Consumer} that accepts the formatted output string
     */
    public void printTo(Consumer<String> printTargetMethod) {
        printTargetMethod.accept(this.getFormattedOutput());
    }
}
