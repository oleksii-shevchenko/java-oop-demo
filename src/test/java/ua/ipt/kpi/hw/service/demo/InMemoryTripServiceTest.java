package ua.ipt.kpi.hw.service.demo;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.ipt.kpi.hw.DomainGenerator;
import ua.ipt.kpi.hw.domain.Trip;
import ua.ipt.kpi.hw.infra.List;
import ua.ipt.kpi.hw.infra.impl.LinkedList;
import ua.ipt.kpi.hw.service.HotelService;
import ua.ipt.kpi.hw.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InMemoryTripServiceTest {
    private static final int DEFAULT_ITERATIONS = 32;

    private InMemoryTripService tripService;

    private UserService userService;

    private HotelService hotelService;

    @Before
    public void setUp() {
        userService = Mockito.mock(UserService.class);
        hotelService = Mockito.mock(HotelService.class);
        tripService = new InMemoryTripService(userService, hotelService);
    }

    @Test
    public void uniqueIdTest() {
        when(userService.exists(anyLong())).thenReturn(true);
        when(hotelService.exists(anyLong())).thenReturn(true);

        var ids = new HashSet<Long>();
        for (int i = 0; i < DEFAULT_ITERATIONS; i++) {
            var id = tripService.register(DomainGenerator.randomTrip());
            assertFalse(ids.contains(id));
            ids.add(id);
        }

        verify(userService, times(DEFAULT_ITERATIONS)).exists(anyLong());
        verify(hotelService, times(DEFAULT_ITERATIONS)).exists(anyLong());
    }

    @Test
    public void getNullOkTest() {
        assertNull(tripService.get(ThreadLocalRandom.current().nextLong()));
    }

    @Test
    public void okPathTest() {
        when(userService.exists(anyLong())).thenReturn(true);
        when(hotelService.exists(anyLong())).thenReturn(true);

        var trip = DomainGenerator.randomTrip();

        var id = tripService.register(trip);

        assertEquals(trip, tripService.get(id));
        assertTrue(tripService.getAll().contains(trip));
        assertEquals(trip, tripService.cancel(id));
        assertNull(tripService.get(id));
    }

    @Test
    public void getAllOkTest() {
        List<Trip> trips = new LinkedList<Trip>();

        for (int i = 0; i < 8; i++) {
            var trip = DomainGenerator.randomTrip();
            trips.add(trip);
            tripService.register(trip);
        }

        assertEquals(trips, tripService.getAll());
    }

    @Test
    public void getAllSizeEffectTest() {
        for (int i = 0; i < 8; i++) {
            tripService.register(DomainGenerator.randomTrip());
        }

        var before = tripService.getAll();

        var sideEffect = tripService.getAll();
        sideEffect.delete(0);
        sideEffect.update(1, DomainGenerator.randomTrip());
        sideEffect.add(DomainGenerator.randomTrip());

        assertEquals(before, tripService.getAll());
        assertNotEquals(sideEffect, tripService.getAll());
    }
}
