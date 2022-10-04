package fr.epu.bicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("GPS Test")
class GPSTest {
    GPS gps;

    @BeforeEach()
    void beforeEach() {
        gps = new GPS();
    }

    @Nested
    @DisplayName("Tests for the GPS object")
    class GPSObjectTest {
        @Test
        @DisplayName("Test that a GPS is correctly initialized")
        void testGPSInitialization() {
            Position p = gps.getPosition();
            assertEquals(0,p.getX());
            assertEquals(0,p.getY());
        }
    }

    @Nested
    @DisplayName("Tests for the move method")
    class moveMethodTest {
        @Test
        @DisplayName("Test that GPS position is moved correctly")
        void positionIsMovedCorrectly() {
            gps.move(3.3,5.2);
            Position p = gps.getPosition();
            assertEquals(3.3,p.getX());
            assertEquals(5.2,p.getY());
        }

        @Test
        @DisplayName("Test that the move method is idempotent")
        void moveMethodIsIdempotent() {
            gps.move(3, 5);
            Position p1 = gps.getPosition();

            gps.move(3, 5);
            Position p2 = gps.getPosition();

            assertEquals(p1.getX(), p2.getX());
            assertEquals(p1.getY(), p2.getY());
        }
    }
}