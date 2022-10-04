package fr.epu.bicycle;

public class GPS {
    private final Position position;

    public GPS() {
        position = new Position();
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(double x, double y) {
        this.position.setX(x);
        this.position.setY(y);
    }
}
