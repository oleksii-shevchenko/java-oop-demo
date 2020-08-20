package ua.ipt.kpi.enums;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class EnumDemo {
    public static void main(String[] args) {
        String city = "Kyiv";

        switch (City.valueOf(city.toUpperCase())) {
            case KYIV:
                System.out.println("Час в Києві " + City.KYIV.time());
                break;
            case LONDON:
                System.out.println("London time is " + City.LONDON.time());
                break;
            default:
                System.out.println("This city is not configured");
        }

        Chrono chrono = City.KYIV;
    }
}

enum City implements Chrono {
    LONDON("Europe/London"), KYIV("Europe/Kiev");

    private final String timezone;

    private City(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public LocalDateTime time() {
        return LocalDateTime.now(ZoneId.of(timezone));
    }
}

interface Chrono {
    LocalDateTime time();
}
