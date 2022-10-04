package fr.epu.bicycle;

public class Position {
    private int x;
    private int y;
    private static final double EPSILON = 000.1;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(0, 0);
    }

    public boolean isEquivalent(Position p) {
        return Math.abs(x-p.x)<EPSILON && Math.abs(y-p.y)< EPSILON;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
