package net.sasu.lib.stopwatch.ext.test;

import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;

public class DurationFormatUtilsDemo {

    public static void main(String[] args) {
        // Sample duration: 3 days, 7 hours, 45 minutes, and 30 seconds
        Duration duration = Duration.ofDays(3)
                .plusHours(7)
                .plusMinutes(45)
                .plusSeconds(30);

        long durationMillis = duration.toMillis();

        System.out.println("Sample Duration: " + duration);
        System.out.println();

        // Demonstrate each method in DurationFormatUtils
        System.out.println("1. formatDuration:");
        System.out.println(DurationFormatUtils.formatDuration(durationMillis, "d 'days' H 'hours' m 'minutes' s 'seconds'"));

        System.out.println("\n2. formatDurationHMS:");
        System.out.println(DurationFormatUtils.formatDurationHMS(durationMillis));

        System.out.println("\n3. formatDurationISO:");
        System.out.println(DurationFormatUtils.formatDurationISO(durationMillis));

        System.out.println("\n4. formatDurationWords:");
        System.out.println(DurationFormatUtils.formatDurationWords(durationMillis, true, true));

        System.out.println("\n5. formatPeriod:");
        System.out.println(DurationFormatUtils.formatPeriod(0, durationMillis, "d 'days' H 'hours' m 'minutes' s 'seconds'"));

        System.out.println("\n6. formatPeriodISO:");
        System.out.println(DurationFormatUtils.formatPeriodISO(0, durationMillis));

        System.out.println("\n7. formatDuration (with seconds):");
        System.out.println(DurationFormatUtils.formatDuration(durationMillis, "HH:mm:ss", true));

        System.out.println("\n8. formatDuration (without seconds):");
        System.out.println(DurationFormatUtils.formatDuration(durationMillis, "HH:mm", false));
    }
}