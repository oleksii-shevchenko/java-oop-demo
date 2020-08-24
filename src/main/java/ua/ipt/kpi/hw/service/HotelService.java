package ua.ipt.kpi.hw.service;

import ua.ipt.kpi.hw.infra.List;
import ua.ipt.kpi.hw.domain.Hotel;

public interface HotelService {
    /**
     * Returns hotel by id. If there is no such
     * hotel, it must return null.
     * @param id Hotel id
     * @return Hotel domain object
     */
    Hotel get(long id);

    /**
     * Returns all stored hotels.
     * @return List of hotels
     */
    List<Hotel> getAll();

    /**
     * Register hotel in in-memory store and returns
     * generated id.
     * @param hotel Hotel to register
     * @return Generated id
     */
    long register(Hotel hotel);

    /**
     * Deletes hotel from in-memory store.
     * @param id Hotel id
     * @return Deleted hotel
     */
    Hotel delete(long id);

    /**
     * Check that hotel with such id has been already registered.
     * @param id Hotel id
     * @return Presence of the hotel in store
     */
    boolean exists(long id);
}
