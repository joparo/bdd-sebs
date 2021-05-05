package org.joparo.sebs;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingTest {

    @Test
    void overlappingBookingsCollide() {
        Booking a = new Booking(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(3), "Alice");
        Booking b = new Booking(1L, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2), "Alice");
        assertTrue(a.collidesWith(b));
        assertTrue(b.collidesWith(a));
    }

    @Test
    void bookingsCanStartImmediatelyAfter() {
        Booking a = new Booking(1L, LocalDateTime.now(), LocalDateTime.now().plusHours(3), "Alice");
        Booking b = new Booking(1L, LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5), "Alice");
        assertFalse(a.collidesWith(b));
        assertFalse(b.collidesWith(a));
    }

    @Test
    void startTimeMustBeAfterStopTime() {
        assertThrows(IllegalArgumentException.class,
                () -> new Booking(1L, LocalDateTime.now(), LocalDateTime.now().minusHours(1), "Alice"));
    }
}
