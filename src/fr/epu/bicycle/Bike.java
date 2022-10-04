package fr.epu.bicycle;

import java.util.Optional;

public class Bike implements Trackable,  Vehicle, Borrowable {
    private Station station;

    public Bike(Station station) {
        super();
        this.station = station;
    }

    @Override
    public Optional<Position> getPosition() {
        Optional<Position> position = Optional.empty();
        if (station != null) {
            position = Optional.of(station.getPosition());
        }
        return position;
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
