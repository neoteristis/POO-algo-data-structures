package fr.epu.bicycle;

public record Station(Position position) {
    public Position getPosition() {
        return this.position;
    }
}
