package ua.ipt.kpi.hw.service.demo;

import ua.ipt.kpi.hw.domain.Hotel;
import ua.ipt.kpi.hw.infra.List;
import ua.ipt.kpi.hw.service.HotelService;

/**
 * Application must be single threaded, so do not care about synchronization
 */
public class InMemoryHotelService implements HotelService {
    @Override
    public Hotel get(long id) {
        // TODO implement
        return null;
    }

    @Override
    public boolean exists(long id) {
        return false;
    }

    @Override
    public List<Hotel> getAll() {
        // TODO implement
        return null;
    }

    @Override
    public long register(Hotel hotel) {
        // TODO implement
        return 0;
    }

    @Override
    public Hotel delete(long id) {
        // TODO implement
        return null;
    }
}
