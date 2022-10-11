package fr.epu.bicycle;

import java.util.Optional;

public class Bike implements Vehicle {
    private Station station;

    public Bike(Station station) {
        super();
        this.station = station;
    }

    @Override
    public Optional<Position> getPosition() {
        return Optional.ofNullable(station.getPosition());
    }

    public void leaveStation() {
        station = null;
    }

    public void joinStation(Station station) {
        this.station = station;
    }

    public boolean isBorrowable() {
        return station != null;
    }
}
