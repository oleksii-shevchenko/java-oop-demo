package ua.ipt.kpi.hw.service.demo;

import ua.ipt.kpi.hw.domain.Trip;
import ua.ipt.kpi.hw.domain.User;
import ua.ipt.kpi.hw.infra.List;
import ua.ipt.kpi.hw.service.HotelService;
import ua.ipt.kpi.hw.service.TripService;
import ua.ipt.kpi.hw.service.UserService;

/**
 * Application must be single threaded, so do not care about synchronization.
 *
 * Hint. Consider using user service and hotel service for validation during
 * registering trip.
 */
public class InMemoryTripService implements TripService {

    public final UserService userService;

    public final HotelService hotelService;

    public InMemoryTripService(UserService userService, HotelService hotelService) {
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @Override
    public long register(Trip trip) {
        return 0;
    }

    @Override
    public Trip get(long id) {
        return null;
    }

    @Override
    public Trip cancel(long id) {
        return null;
    }

    @Override
    public List<Trip> getAll() {
        return null;
    }
}
