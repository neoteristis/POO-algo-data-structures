package fr.epu.bicycle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Position Test")
class PositionTest {

    private static final Position p1 = new Position(3,4);
    private static final Position p2 = new Position(7,1);

    private static final Position p3 = new Position(3,4.002);
    private static final Position p4 = new Position(2.999,4.001);

    @Nested
    @DisplayName("Test the Position object")
    class positionInitializationTest {

    }

    @Nested
    @DisplayName("Test the equivalent method")
    class equivalentMethodTest {
        @Test
        @DisplayName("Test that two near enough positions are equivalent")
        void nearEnoughPositionsAreEquivalent(){
            assertFalse(p1.isEquivalent(p2));
            assertTrue(p3.isEquivalent(p4));
        }
    }

    @Nested
    @DisplayName("Test the distance method")
    class distanceMethodTest {
        @Test
        @DisplayName("Test that the distance is commutative")
        void distanceIsCommutative() {
            assertEquals(p1.distance(p2), p2.distance(p1));
        }

        @Test
        @DisplayName("Test that the distance is calculated correctly")
        void distanceIsCalculatedCorrectly() {
            assertEquals(5, p2.distance(p1), 0.001);
            assertNotEquals(1, p3.distance(p4), 0.001);
        }
    }
}