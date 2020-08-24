package ua.ipt.kpi.hw;

import ua.ipt.kpi.hw.domain.Hotel;
import ua.ipt.kpi.hw.domain.Trip;
import ua.ipt.kpi.hw.domain.User;

public final class DomainGenerator {
    private DomainGenerator() {}

    public static Trip randomTrip() {
        // TODO implement random trip generator
        // HINT consider using random hotel and random user generators
        throw new RuntimeException("Not implemented");
    }

    public static Trip randomTrip(User user, Hotel hotel) {
        // TODO implement
        // Trip must be based on passed arguments
        throw new RuntimeException("Not implemented");
    }

    public static User randomUser() {
        // TODO implement
        throw new RuntimeException("Not implemented");
    }

    public static Hotel randomHotel() {
        // TODO implement
        throw new RuntimeException("Not implemented");
    }
}
