package net.sasu.lib.time.output;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Outputs something convertable to human-readable text
 */
public abstract class OutputSource<OutputSourceType extends OutputSource<OutputSourceType>> {

    private final OutputSourceType outputSourceType;
    private Function<OutputSourceType, String> formatter = Object::toString;

    protected OutputSource(Class<OutputSourceType> typeToken) {
        this.outputSourceType = typeToken.cast(this);
    }

    public OutputSourceType getOutput() {
        return outputSourceType;
    }

    /**
     * Returns formatted content (relying on toString to be implemented in a way which makes sense)
     * @return Formatted content string
     */
    public String getFormattedOutput() {
        return this.formatter.apply(getOutput());
    }

    public OutputSourceType format(Function<OutputSourceType, String> outputFormatter) {
        this.formatter = outputFormatter;
        return this.outputSourceType;
    }

    public void println() {
        System.out.println(getFormattedOutput());
    }

    public void printTo(Consumer<String> printTargetMethod) {
        printTargetMethod.accept(this.getFormattedOutput());
    }
}