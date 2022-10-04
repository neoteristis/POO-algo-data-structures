package fr.epu.bicycle;

/**
 * EBike implements the computer part of an EBike that would have a battery and a location.
 * @author Raphael Anjou
 */
public class EBike extends ElectricVehicle {
    static final int INITIAL_DISTANCE = 1;

    /**
     * EBike constructor
     * Initialize distance, create a new GPS and a new Battery
     */
    public EBike() {
        super();
        this.km = INITIAL_DISTANCE;
    }

    /**
     * Change the number of kilometers of the bike to the one specified
     * @param km int
     */
    public void setKm(int km) {
        this.km = km;
    }
}
