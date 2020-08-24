package ua.ipt.kpi.hw.service;

import ua.ipt.kpi.hw.infra.List;
import ua.ipt.kpi.hw.domain.Trip;
import ua.ipt.kpi.hw.domain.User;

public interface TripService {
    /**
     * Validates register request and in case
     * everything is ok register trip and returns
     * generated trip id.
     * @param trip Trip
     * @return Generated trip id
     */
    long register(Trip trip);

    /**
     * Returns trip by id. If there is no such trip
     * should return null.
     * @param id Trip id
     * @return Trip domain object
     */
    Trip get(long id);

    /**
     * Cancel trip and remove it from in-memory store.
     * In case there is no such trip must thrown an
     * {@link RuntimeException}.
     * @param id Trip id
     * @return Canceled trip
     */
    Trip cancel(long id);

    /**
     * List all registered trips.
     * @return List of trips.
     */
    List<Trip> getAll();
}
