package net.sasu.lib.time.duration;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.util.TimeZone;
import java.util.function.Function;

public class DurationFormatters {

    public static Function<Duration, String> formatDuration(final String format, final boolean padWithZeros){
        return (duration) ->
                DurationFormatUtils.formatDuration(duration.toMillis(), format, padWithZeros);
    }

    public static Function<Duration, String> formatDuration(final String format){
        return (duration) ->
                DurationFormatUtils.formatDuration(duration.toMillis(), format);
    }

    public static Function<Duration, String> formatDurationHMS(){
        return (duration) ->
                DurationFormatUtils.formatDurationHMS(duration.toMillis());
    }

    public static Function<Duration, String> formatDurationISO(){
        return (duration) ->
                DurationFormatUtils.formatDurationISO(duration.toMillis());
    }

    public static Function<Duration, String> formatDurationWords(final boolean suppressLeadingZeroElements, final boolean suppressTrailingZeroElements){
        return (duration) ->
                DurationFormatUtils.formatDurationWords(duration.toMillis(), suppressLeadingZeroElements, suppressTrailingZeroElements);
    }

    public static Function<Duration, String> formatPeriod(final long startMillis, final String format){
        return (duration) ->
                DurationFormatUtils.formatPeriod(startMillis, startMillis + duration.toMillis(), format);
    }

    public static Function<Duration, String> formatPeriod(final long startMillis, final String format, final boolean padWithZeros, final TimeZone timezone){
        return (duration) ->
                DurationFormatUtils.formatPeriod(startMillis, startMillis + duration.toMillis(), format, padWithZeros, timezone);
    }

    public static Function<Duration, String> formatPeriodISO(final long startMillis){
        return (duration) ->
                DurationFormatUtils.formatPeriodISO(startMillis, startMillis + duration.toMillis());
    }
}
