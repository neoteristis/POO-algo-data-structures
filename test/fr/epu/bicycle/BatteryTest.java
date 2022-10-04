package fr.epu.bicycle;

import static org.junit.jupiter.api.Assertions.*;

class BatteryTest {

    @org.junit.jupiter.api.Test
    void testBatteryChargeInitial() {
        Battery b = new Battery(12);
        assertEquals(0, b.getCharge());
        b.charge(10);
        assertEquals(10, b.getCharge());
    }

    @org.junit.jupiter.api.Test
    void testBatteryCharge() {
        Battery b = new Battery(12);
        assertEquals(0, b.getCharge());
        b.charge(10);
        assertEquals(10, b.getCharge());
        b.charge(1);
        assertEquals(11, b.getCharge());
    }

    @org.junit.jupiter.api.Test
    void testBatteryMaxCharge() {
        Battery b = new Battery(12);
        assertEquals(0, b.getCharge());
        b.charge(10);
        assertEquals(10, b.getCharge());
        b.charge(20);
        assertEquals(12, b.getCharge());
    }
}