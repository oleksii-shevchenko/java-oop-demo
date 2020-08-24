package ua.ipt.kpi.hw.service.demo;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Before;
import org.junit.Test;
import ua.ipt.kpi.hw.DomainGenerator;
import ua.ipt.kpi.hw.domain.Hotel;
import ua.ipt.kpi.hw.infra.impl.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class InMemoryHotelServiceTest {
    private static final int DEFAULT_ITERATIONS = 1024;

    private InMemoryHotelService hotelService;

    @Before
    public void setUp() {
        hotelService = new InMemoryHotelService();
    }

    @Test
    public void emptyOkTest() {
        assertNull(hotelService.get(ThreadLocalRandom.current().nextLong()));
    }

    @Test
    public void uniqueIdTest() {
        var ids = new HashSet<Long>();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            var id = hotelService.register(DomainGenerator.randomHotel());
            assertFalse(ids.contains(id));
            ids.add(id);
        }
    }

    @Test
    public void regularPathOkTest() {
        var hotel = DomainGenerator.randomHotel();

        var id = hotelService.register(hotel);

        assertTrue(hotelService.exists(id));
        assertEquals(hotel, hotelService.get(id));
        assertEquals(hotel, hotelService.delete(id));
        assertFalse(hotelService.exists(id));
        assertNull(hotelService.get(id));
    }

    @Test
    public void deleteExceptionTest() {
        try {
            hotelService.delete(ThreadLocalRandom.current().nextLong());
            fail();
        } catch (Exception e) {
            // Expected
        }
    }

    @Test
    public void getAllOkTest() {
        var hotels = new LinkedList<Hotel>();

        for (int i = 0; i < 8; i++) {
            var hotel = DomainGenerator.randomHotel();
            hotels.add(hotel);
            hotelService.register(hotel);
        }

        assertEquals(hotels, hotelService.getAll());
    }

    @Test
    public void getAllSizeEffectTest() {
        for (int i = 0; i < 8; i++) {
            hotelService.register(DomainGenerator.randomHotel());
        }

        var before = hotelService.getAll();

        var sideEffect = hotelService.getAll();
        sideEffect.delete(0);
        sideEffect.update(1, DomainGenerator.randomHotel());
        sideEffect.add(DomainGenerator.randomHotel());

        assertEquals(before, hotelService.getAll());
        assertNotEquals(sideEffect, hotelService.getAll());
    }

}
