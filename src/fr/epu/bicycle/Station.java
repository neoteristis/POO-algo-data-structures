package fr.epu.bicycle;

public class Station {
    private final Position position;

    public Station(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }
}
