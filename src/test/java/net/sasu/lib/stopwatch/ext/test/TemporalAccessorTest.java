package net.sasu.lib.stopwatch.ext.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TemporalAccessorTest {

    private LocalDateTime dateTime;

    @BeforeEach
    public void setUp() {
        // Set up a LocalDateTime instance for testing
        dateTime = LocalDateTime.of(2023, 10, 5, 14, 30, 45);
    }

    // Test for valid ChronoField values
    @Test
    public void testGetLongForSupportedChronoField() {
        // Test ChronoField.YEAR
        assertEquals(2023L, dateTime.getLong(ChronoField.YEAR));

        // Test ChronoField.MONTH_OF_YEAR
        assertEquals(10L, dateTime.getLong(ChronoField.MONTH_OF_YEAR));

        // Test ChronoField.DAY_OF_MONTH
        assertEquals(5L, dateTime.getLong(ChronoField.DAY_OF_MONTH));

        // Test ChronoField.HOUR_OF_DAY
        assertEquals(14L, dateTime.getLong(ChronoField.HOUR_OF_DAY));

        // Test ChronoField.MINUTE_OF_HOUR
        assertEquals(30L, dateTime.getLong(ChronoField.MINUTE_OF_HOUR));

        // Test ChronoField.SECOND_OF_MINUTE
        assertEquals(45L, dateTime.getLong(ChronoField.SECOND_OF_MINUTE));
    }

    // Test for unsupported ChronoField values
    @Test
    public void testGetLongForUnsupportedChronoField() {
        TemporalField unsupportedField = Mockito.mock(TemporalField.class);
        when(unsupportedField.getFrom(any())).thenThrow(new UnsupportedTemporalTypeException("Unsupported field"));

        UnsupportedTemporalTypeException exception = assertThrows(
                UnsupportedTemporalTypeException.class,
                () -> dateTime.getLong(unsupportedField)
        );

        assertEquals("Unsupported field", exception.getMessage());
    }

    // Test when field is not ChronoField but is supported by getFrom
    @Test
    public void testGetLongForNonChronoField() {
        TemporalField nonChronoField = mock(TemporalField.class);

        // Mock the behavior of getFrom() to return a valid long value
        when(nonChronoField.getFrom(dateTime)).thenReturn(123L);

        long result = dateTime.getLong(nonChronoField);
        assertEquals(123L, result);
    }

    // Test when DateTimeException is thrown
    @Test
    public void testGetLongThrowsDateTimeException() {
        TemporalField invalidField = mock(TemporalField.class);

        // Simulate throwing a DateTimeException from getFrom
        when(invalidField.getFrom(dateTime)).thenThrow(new DateTimeException("Cannot get value"));

        DateTimeException exception = assertThrows(
                DateTimeException.class,
                () -> dateTime.getLong(invalidField)
        );

        assertEquals("Cannot get value", exception.getMessage());
    }

    // Test when numeric overflow occurs
    @Test
    public void testGetLongThrowsArithmeticException() {
        TemporalField overflowField = mock(TemporalField.class);

        // Simulate throwing an ArithmeticException from getFrom
        when(overflowField.getFrom(dateTime)).thenThrow(new ArithmeticException("Numeric overflow"));

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> dateTime.getLong(overflowField)
        );

        assertEquals("Numeric overflow", exception.getMessage());
    }

    // Test that observable state is not altered (this can be tested indirectly)
    @Test
    public void testGetLongDoesNotAlterState() {
        // Capture the original state of the LocalDateTime instance
        LocalDateTime originalDateTime = dateTime;

        // Call getLong on a supported ChronoField
        long year = dateTime.getLong(ChronoField.YEAR);

        // Ensure the method returns the correct value
        assertEquals(2023L, year);

        // Ensure the original LocalDateTime instance is still the same (no state changes)
        assertEquals(originalDateTime, dateTime);
    }
}
