package fr.epu.bicycle;

import java.util.Optional;

public class ElectricVehicle implements Vehicle {
    static final int INITIAL_CHARGE = 10;
    protected final GPS gps;
    protected final Battery battery;
    protected double km;
    private boolean isBorrowed = false;

    public ElectricVehicle() {
        this.gps = new GPS();
        this.battery = new Battery(INITIAL_CHARGE);
    }

    public int getCharge() {
        return this.battery.getCharge();
    }

    public Optional<Position> getPosition() {
        if (battery.getCharge() > 0) {
            return Optional.of(this.gps.getPosition());

        }
        return Optional.empty();
    }

    /**
     * Get current electric vehicle kilometers
     *
     * @return kilometers as an int
     */
    public double getKm() {
        return km;
    }

    /**
     * Modifies the number of km traveled by adding <code>nbKmToAdd</code> km.
     *
     * @param nbKmToAdd
     */
    public void addKm(double nbKmToAdd) {
        if (nbKmToAdd > 0) {
            this.km += nbKmToAdd;
        }
    }

    @Override
    public boolean isBorrowable() {
        return !isBorrowed && battery.getChargePercentage() >= 20.0;
    }
}
