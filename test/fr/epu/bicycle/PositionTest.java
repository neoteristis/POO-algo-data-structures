package fr.epu.bicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Position Test")
class PositionTest {
    private static Position p1;
    private static Position p2;
    private static Position p3;
    private static Position p4;

    @BeforeEach
    void beforeEach() {
        p1 = new Position(3, 4);
        p2 = new Position(7, 1);

        p3 = new Position(3, 4.002);
        p4 = new Position(2.999, 4.001);
    }

    @Nested
    @DisplayName("constructor method")
    class ConstructorMethodTest {
        @Nested
        @DisplayName("without parameters")
        class ConstructorWithoutParametersTest{
            @Test
            @DisplayName("Test that the coordinates are the default one")
            void constructor_whenInitializedWithoutParameters_defaultCoordinates () {
                Position p0 = new Position();
                assertEquals(0, p0.getX());
                assertEquals(0, p0.getY());
            }
        }

        @Nested
        @DisplayName("with parameters")
        class ConstructorWithParametersTest {
            @Test
            @DisplayName("Test that the coordinates equals the one entered as parameters as numbers")
            void constructor_whenInitializedWithTwoNumbers_coordinatesAreCorrect() {
                // With integers
                assertEquals(3, p1.getX());
                assertEquals(4, p1.getY());

                // With double
                assertEquals(2.999, p4.getX());
                assertEquals(4.001, p4.getY());
            }
        }
    }

    @Nested
    @DisplayName("equivalent method")
    class EquivalentMethodTest {
        @Test
        @DisplayName("Test that two near enough positions are equivalent")
        void equivalent_whenTwoPositionsAreNearEnough_true(){
            Position pointLimitCase01 = new Position(1, 1);
            Position pointLimitCase02 = new Position(1 + Position.EPSILON, 1 + Position.EPSILON);
            Position pointLimitCase03 = new Position(1 + Position.EPSILON * 2, 1 + Position.EPSILON * 2);

            // Near enough positions
            assertTrue(p3.isEquivalent(p4));
            assertTrue(p1.isEquivalent(p1));
            assertTrue(pointLimitCase01.isEquivalent(pointLimitCase02));

            // Not near enough positions
            assertFalse(p1.isEquivalent(p2));
            assertFalse(p2.isEquivalent(p3));
            assertFalse(p1.isEquivalent(p4));
            assertFalse(pointLimitCase01.isEquivalent(pointLimitCase03));
        }
    }

    @Nested
    @DisplayName("distance method")
    class DistanceMethodTest {
        @Test
        @DisplayName("Test that the distance is commutative")
        void distance_whenPositionsAreSwitched_isTheSame() {
            assertEquals(p1.distance(p2), p2.distance(p1));
        }

        @Test
        @DisplayName("Test that the distance is calculated correctly")
        void distance_whenGivenTwoPositions_isCalculatedCorrectly() {
            assertEquals(5, p2.distance(p1), 0.001);
            assertNotEquals(1, p3.distance(p4), 0.001);
        }
    }
}