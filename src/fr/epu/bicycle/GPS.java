package fr.epu.bicycle;

public class GPS {
    private Position position;

    public GPS() {
        position = new Position();
    }

    public Position getPosition() {
        return this.position;
    }

    public void move(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
    }
}
