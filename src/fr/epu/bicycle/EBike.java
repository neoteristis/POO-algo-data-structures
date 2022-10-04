package fr.epu.bicycle;

/**
 * EBike implements the computer part of an EBike that would have a battery and a location.
 * @author Raphael Anjou
 */
public class EBike {
    private int km;
    private final GPS gps;
    private final Battery battery;
    static final int INITIAL_DISTANCE = 1;
    static final int INITIAL_CHARGE = 10;

    /**
     * EBike constructor
     * Initialize distance, create a new GPS and a new Battery
     */
    public EBike() {
        this.km = INITIAL_DISTANCE;
        this.gps = new GPS();
        this.battery = new Battery(INITIAL_CHARGE);
    }

    /**
     * Get current Ebike kilometers
     * @return kilometers as an int
     */
    public int getKm() {
        return km;
    }

    /**
     * Change the number of kilometers of the bike to the one specified
     * @param km int
     */
    public void setKm(int km) {
        this.km = km;
    }

    /**
     * Modifies the number of km traveled by adding <code>nbKmToAdd</code> km.
     * @param nbKmToAdd
     */
    public void addKm(int nbKmToAdd){
        if (nbKmToAdd > 0) {
            this.km += nbKmToAdd;
        }
    }

    public Position getPosition() {
        return this.gps.getPosition();
    }

    public int getCharge() {
        return this.battery.getCharge();
    }
}
