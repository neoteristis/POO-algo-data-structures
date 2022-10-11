package fr.epu.bicycle;

public class Battery {
    private int charge;
    private final int maxCharge;

    public Battery(int maxCharge) {
        this.charge = 0;
        if (maxCharge > 0) {
            this.maxCharge = maxCharge;
        } else {
            throw new IllegalArgumentException("input must be a strictly positive integer");
        }
    }

    public int getCharge() {
        return charge;
    }

    public void charge(int chargeToAdd) {
        if (chargeToAdd < 0) {
            throw new IllegalArgumentException("input must be a positive integer");
        }

        this.charge += chargeToAdd;

        if (this.charge > maxCharge) {
            this.charge = maxCharge;
        }
    }

    public double getChargePercentage() {
        return ((double) charge * 100) / ((double) maxCharge);
    }
}
