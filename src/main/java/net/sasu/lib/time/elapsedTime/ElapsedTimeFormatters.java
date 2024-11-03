package net.sasu.lib.time.elapsedTime;

import net.sasu.lib.time.duration.DurationFormatters;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.TimeZone;
import java.util.function.Function;

/**
 * Provides static methods for creating formatting functions for {@link ElapsedTime} instances,
 * using various formats for durations and periods.
 * <p>>
 * Static methods providing formatting functions with the same
 * method signatures as the public methods in {@link DurationFormatUtils}
 * except that the first parameter is absent, as it is provided by the caller
 * of the generated function.
 */
public class ElapsedTimeFormatters {

    /**
     * Returns a function that formats the duration of an {@link ElapsedTime} instance according to the specified format.
     *
     * @param format       the format string
     * @param padWithZeros whether to pad with zeros
     * @return a function that takes an {@link ElapsedTime} and returns the formatted duration as a {@link String}
     */
    public static Function<ElapsedTime, String> formatDuration(final String format, final boolean padWithZeros) {
        return (elapsedTime) -> DurationFormatters.formatDuration(format, padWithZeros).apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the duration of an {@link ElapsedTime} instance according to the specified format without padding.
     *
     * @param format the format string
     * @return a function that takes an {@link ElapsedTime} and returns the formatted duration as a {@link String}
     */
    public static Function<ElapsedTime, String> formatDuration(final String format) {
        return (elapsedTime) -> DurationFormatters.formatDuration(format).apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the duration of an {@link ElapsedTime} instance in hours, minutes, and seconds.
     *
     * @return a function that takes an {@link ElapsedTime} and returns the formatted duration in "H:mm:ss.SSS" format as a {@link String}
     */
    public static Function<ElapsedTime, String> formatDurationHMS() {
        return (elapsedTime) -> DurationFormatters.formatDurationHMS().apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the duration of an {@link ElapsedTime} instance in ISO 8601 format.
     *
     * @return a function that takes an {@link ElapsedTime} and returns the formatted duration in ISO 8601 format as a {@link String}
     */
    public static Function<ElapsedTime, String> formatDurationISO() {
        return (elapsedTime) -> DurationFormatters.formatDurationISO().apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the duration of an {@link ElapsedTime} instance as words,
     * with options to suppress leading or trailing zero elements.
     *
     * @param suppressLeadingZeroElements  whether to suppress leading zero elements
     * @param suppressTrailingZeroElements whether to suppress trailing zero elements
     * @return a function that takes an {@link ElapsedTime} and returns the formatted duration as words in a {@link String}
     */
    public static Function<ElapsedTime, String> formatDurationWords(final boolean suppressLeadingZeroElements, final boolean suppressTrailingZeroElements) {
        return (elapsedTime) -> DurationFormatters.formatDurationWords(suppressLeadingZeroElements, suppressTrailingZeroElements).apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the period between a specified start time and the duration of an {@link ElapsedTime} instance.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @return a function that takes an {@link ElapsedTime} and returns the formatted period as a {@link String}
     */
    public static Function<ElapsedTime, String> formatPeriod(final long startMillis, final String format) {
        return (elapsedTime) -> DurationFormatters.formatPeriod(startMillis, format).apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the period between a specified start time and the duration of an {@link ElapsedTime} instance,
     * with optional zero-padding and timezone.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @param padWithZeros whether to pad with zeros
     * @param timezone    the time zone for formatting
     * @return a function that takes an {@link ElapsedTime} and returns the formatted period as a {@link String}
     */
    public static Function<ElapsedTime, String> formatPeriod(final long startMillis, final String format, final boolean padWithZeros, final TimeZone timezone) {
        return (elapsedTime) -> DurationFormatters.formatPeriod(startMillis, format, padWithZeros, timezone).apply(elapsedTime.getDuration());
    }

    /**
     * Returns a function that formats the period between a specified start time and the duration of an {@link ElapsedTime} instance in ISO 8601 format.
     *
     * @param startMillis the start time in milliseconds
     * @return a function that takes an {@link ElapsedTime} and returns the formatted period in ISO 8601 format as a {@link String}
     */
    public static Function<ElapsedTime, String> formatPeriodISO(final long startMillis) {
        return (elapsedTime) -> DurationFormatters.formatPeriodISO(startMillis).apply(elapsedTime.getDuration());
    }
}
