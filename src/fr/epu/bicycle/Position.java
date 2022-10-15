package fr.epu.bicycle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Position {
    private double x;
    private double y;
    public static final double EPSILON = 0.001;

    /**
     * Constructor of the Position Class.
     *
     * It will initialize the x and y coordinates with the parameter values.
     *
     * @param x a double representing the x coordinate
     * @param y a double representing the y coordinate
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor of the Position Class.
     *
     * Calls the other constructor with values x=0 and y=0
     */
    public Position() {
        this(0, 0);
    }

    /**
     * @return x coordinate (double)
     */
    public double getX() {
        return x;
    }

    /**
     * @return y coordinate (double)
     */
    public double getY() {
        return y;
    }

    /**
     *
     * @param x coordinate to set (double)
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     *
     * @param y coordinate to set (double)
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Verify that two points are equivalent by calculating the distance between their respective coordinates
     * and comparing it to an epsilon constant defined in the class.
     * If the difference between two number is smaller than epsilon, then those numbers are equivalent.
     *
     * @param p the position to compare to
     * @return a boolean
     */
    public boolean isEquivalent(Position p) {
        BigDecimal xDifference = BigDecimal.valueOf(Math.abs(x - p.x)).setScale(4, RoundingMode.CEILING);
        BigDecimal yDifference = BigDecimal.valueOf(Math.abs(y - p.y)).setScale(4, RoundingMode.CEILING);
        BigDecimal epsilon = BigDecimal.valueOf(EPSILON);

        return xDifference.compareTo(epsilon) <= 0 && yDifference.compareTo(epsilon) <= 0;
    }

    /**
     * Calculate the distance between current point and the one given as parameter.
     *
     * @param p the position to calculate the distance to
     * @return the distance as a boolean
     */
    public double distance(Position p) {
        return Math.sqrt(Math.pow(p.y - this.y, 2) + Math.pow(p.x - this.x, 2));
    }
}
