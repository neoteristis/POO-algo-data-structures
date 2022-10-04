package fr.epu.bicycle;

public class Position {
    private double x;
    private double y;
    private static final double EPSILON = 000.1;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
        this(0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public boolean isEquivalent(Position p) {
        return Math.abs(x-p.x)<EPSILON && Math.abs(y-p.y)< EPSILON;
    }

    public double distance(Position p) {
        return Math.sqrt(Math.pow(p.y - this.y, 2) + Math.pow(p.x - this.x, 2));
    }
}
