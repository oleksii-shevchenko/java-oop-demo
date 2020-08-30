package ua.ipt.kpi.hw.domain;

import org.junit.Test;
import ua.ipt.kpi.hw.DomainGenerator;

import static org.junit.Assert.*;

public class HotelTest {
    private static final int DEFAULT_ITERATIONS = 32;

    @Test
    public void nullOkTest() {
        assertFalse(DomainGenerator.randomHotel().equals(null));
    }

    @Test
    public void reflectivityOkTest() {
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            var hotel = DomainGenerator.randomHotel();
            assertEquals(hotel, hotel);
        }
    }
}