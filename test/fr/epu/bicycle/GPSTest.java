package fr.epu.bicycle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GPSTest {

    @Test
    void testMove() {
        GPS gps = new GPS();
        Position p = gps.getPosition();
        assertEquals(0,p.getX());
        assertEquals(0,p.getY());
        gps.move(3,5);
        p = gps.getPosition();
        assertEquals(3,p.getX());
        assertEquals(5,p.getY());

    }
}