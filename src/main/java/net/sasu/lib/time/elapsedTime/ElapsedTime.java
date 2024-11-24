package net.sasu.lib.time.elapsedTime;

import net.sasu.lib.time.output.OutputSource;

import java.time.Duration;
import java.util.TimeZone;

/**
 * Represents a specific duration of elapsed time, extending {@link OutputSource} to provide
 * customizable formatting options. Supports various formatting styles through the use of
 * formatting methods.
 */
public class ElapsedTime extends OutputSource<ElapsedTime> {

    final Duration duration;

    /**
     * Creates an {@code ElapsedTime} instance with the specified duration.
     *
     * @param duration the duration represented by this {@code ElapsedTime}
     */
    public ElapsedTime(Duration duration) {
        super(ElapsedTime.class);
        this.duration = duration;
    }

    /**
     * Returns this {@code ElapsedTime} instance.
     *
     * @return the current instance of {@code ElapsedTime}
     */
    @Override
    public ElapsedTime getOutput() {
        return this;
    }

    /**
     * Returns the duration represented by this {@code ElapsedTime}.
     *
     * @return the {@link Duration} of this {@code ElapsedTime}
     */
    public Duration getDuration() {
        return duration;
    }

    // Formatting methods

    /**
     * Sets the format for the duration using the specified format string and padding option.
     *
     * @param format       the format string
     * @param padWithZeros whether to pad with zeros
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatDuration(final String format, final boolean padWithZeros) {
        return this.format(ElapsedTimeFormatters.formatDuration(format, padWithZeros));
    }

    /**
     * Sets the format for the duration using the specified format string without padding.
     *
     * @param format the format string
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatDuration(final String format) {
        return this.format(ElapsedTimeFormatters.formatDuration(format));
    }

    /**
     * Sets the format for the duration in hours, minutes, and seconds.
     *
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatDurationHMS() {
        return this.format(ElapsedTimeFormatters.formatDurationHMS());
    }

    /**
     * Sets the format for the duration in ISO 8601 format.
     *
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatDurationISO() {
        return this.format(ElapsedTimeFormatters.formatDurationISO());
    }

    /**
     * Sets the format for the duration in words, with options to suppress leading or trailing zero elements.
     *
     * @param suppressLeadingZeroElements  whether to suppress leading zero elements
     * @param suppressTrailingZeroElements whether to suppress trailing zero elements
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatDurationWords(final boolean suppressLeadingZeroElements, final boolean suppressTrailingZeroElements) {
        return this.format(ElapsedTimeFormatters.formatDurationWords(suppressLeadingZeroElements, suppressTrailingZeroElements));
    }

    /**
     * Sets the format for the period between a specified start time and the duration represented by this {@code ElapsedTime}.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatPeriod(final long startMillis, final String format) {
        return this.format(ElapsedTimeFormatters.formatPeriod(startMillis, format));
    }

    /**
     * Sets the format for the period between a specified start time and the duration represented by this {@code ElapsedTime},
     * with options for zero-padding and a specified timezone.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @param padWithZeros whether to pad with zeros
     * @param timezone    the time zone for formatting
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatPeriod(final long startMillis, final String format, final boolean padWithZeros, final TimeZone timezone) {
        return this.format(ElapsedTimeFormatters.formatPeriod(startMillis, format, padWithZeros, timezone));
    }

    /**
     * Sets the format for the period between a specified start time and the duration represented by this {@code ElapsedTime}
     * in ISO 8601 format.
     *
     * @param startMillis the start time in milliseconds
     * @return this {@code ElapsedTime} instance with the updated format
     */
    public ElapsedTime formatPeriodISO(final long startMillis) {
        return this.format(ElapsedTimeFormatters.formatPeriodISO(startMillis));
    }

    @Override
    public String toString() {
        return this.formatDurationHMS().getFormattedOutput();
    }
}
