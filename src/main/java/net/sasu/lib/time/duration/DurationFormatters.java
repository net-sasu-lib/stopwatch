package net.sasu.lib.time.duration;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.util.TimeZone;
import java.util.function.Function;

/**
 * Static methods providing formatting functions with the same
 * method signatures as the public methods in {@link DurationFormatUtils}
 * except that the first parameter is absent, as it is provided by the caller
 * of the generated function.
 */
public class DurationFormatters {

    /**
     * Constructor to prevent non-static construction
     * @throws IllegalAccessException always
     */
    private DurationFormatters() throws IllegalAccessException {
        throw new IllegalAccessException("Static use only");
    }

    /**
     * Returns a function that formats a {@link Duration} according to the specified format.
     *
     * @param format       the format string
     * @param padWithZeros whether to pad with zeros
     * @return a function that takes a {@link Duration} and returns the formatted duration as a {@link String}
     */
    public static Function<Duration, String> formatDuration(final String format, final boolean padWithZeros) {
        return (duration) ->
                DurationFormatUtils.formatDuration(duration.toMillis(), format, padWithZeros);
    }

    /**
     * Returns a function that formats a {@link Duration} according to the specified format without padding.
     *
     * @param format the format string
     * @return a function that takes a {@link Duration} and returns the formatted duration as a {@link String}
     */
    public static Function<Duration, String> formatDuration(final String format) {
        return (duration) ->
                DurationFormatUtils.formatDuration(duration.toMillis(), format);
    }

    /**
     * Returns a function that formats a {@link Duration} in hours, minutes, and seconds.
     *
     * @return a function that takes a {@link Duration} and returns the formatted duration in "H:mm:ss.SSS" format as a {@link String}
     */
    public static Function<Duration, String> formatDurationHMS() {
        return (duration) ->
                DurationFormatUtils.formatDurationHMS(duration.toMillis());
    }

    /**
     * Returns a function that formats a {@link Duration} in ISO 8601 format.
     *
     * @return a function that takes a {@link Duration} and returns the formatted duration in ISO 8601 format as a {@link String}
     */
    public static Function<Duration, String> formatDurationISO() {
        return (duration) ->
                DurationFormatUtils.formatDurationISO(duration.toMillis());
    }

    /**
     * Returns a function that formats a {@link Duration} as words, with options to suppress leading or trailing zero elements.
     *
     * @param suppressLeadingZeroElements  whether to suppress leading zero elements
     * @param suppressTrailingZeroElements whether to suppress trailing zero elements
     * @return a function that takes a {@link Duration} and returns the formatted duration as words in a {@link String}
     */
    public static Function<Duration, String> formatDurationWords(final boolean suppressLeadingZeroElements, final boolean suppressTrailingZeroElements) {
        return (duration) ->
                DurationFormatUtils.formatDurationWords(duration.toMillis(), suppressLeadingZeroElements, suppressTrailingZeroElements);
    }

    /**
     * Returns a function that formats the period between a specified start time and the given {@link Duration}.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @return a function that takes a {@link Duration} and returns the formatted period as a {@link String}
     */
    public static Function<Duration, String> formatPeriod(final long startMillis, final String format) {
        return (duration) ->
                DurationFormatUtils.formatPeriod(startMillis, startMillis + duration.toMillis(), format);
    }

    /**
     * Returns a function that formats the period between a specified start time and the given {@link Duration} with optional zero-padding and timezone.
     *
     * @param startMillis the start time in milliseconds
     * @param format      the format string
     * @param padWithZeros whether to pad with zeros
     * @param timezone    the time zone for formatting
     * @return a function that takes a {@link Duration} and returns the formatted period as a {@link String}
     */
    public static Function<Duration, String> formatPeriod(final long startMillis, final String format, final boolean padWithZeros, final TimeZone timezone) {
        return (duration) ->
                DurationFormatUtils.formatPeriod(startMillis, startMillis + duration.toMillis(), format, padWithZeros, timezone);
    }

    /**
     * Returns a function that formats the period between a specified start time and the given {@link Duration} in ISO 8601 format.
     *
     * @param startMillis the start time in milliseconds
     * @return a function that takes a {@link Duration} and returns the formatted period in ISO 8601 format as a {@link String}
     */
    public static Function<Duration, String> formatPeriodISO(final long startMillis) {
        return (duration) ->
                DurationFormatUtils.formatPeriodISO(startMillis, startMillis + duration.toMillis());
    }
}
