package fr.epu.bicycle;

public class Battery {
    private int charge;
    private int maxCharge;

    public Battery(int maxCharge) {
        this.charge = 0;
        this.maxCharge = maxCharge;
    }

    public int getCharge() {
        return charge;
    }

    public void charge(int chargeToAdd) {
        this.charge += chargeToAdd;
        if (this.charge > maxCharge) {
            this.charge = maxCharge;
        }
    }
}
