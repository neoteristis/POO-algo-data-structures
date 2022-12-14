package fr.epu.bicycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Battery class tests")
class BatteryTest {

    private Battery battery;
    private static final int MAX_CHARGE = 12;

    @BeforeEach
    void beforeEach() {
        battery = new Battery(MAX_CHARGE);
    }

    @Nested
    @DisplayName("constructor method")
    class ConstructorMethodTest {
        @Test
        @DisplayName("Test that the charge is initialized correctly")
        void testBatteryChargeValueAfterInitialization() {
            assertEquals(0, battery.getCharge());
        }

        @Test
        @DisplayName("Test that it can't be initialized with a negative charge")
        void testBatteryInitialisationWithNegativeCharge() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                battery = new Battery(-1);
            });

            String expectedException = "input must be a strictly positive integer";

            assertEquals(exception.getMessage(), expectedException);
        }

        @Test
        @DisplayName("when maxCharge is 0")
        void constructor_whenMaxChargeIsZero_thenThrowException() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                battery = new Battery(0);
            });

            String expectedException = "input must be a strictly positive integer";

            assertEquals(exception.getMessage(), expectedException);
        }
    }

    @Nested
    @DisplayName("charge method")
    class ChargeMethodTest {
        @Test
        @DisplayName("Test charging with a positive integer")
        void testChargingWithPositiveInteger() {
            battery.charge(10);
            assertEquals(10, battery.getCharge());
            battery.charge(1);
            assertEquals(11, battery.getCharge());
        }

        @Test
        @DisplayName("Test charging with a negative integer")
        void testChargingWithNegativeInteger() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                battery.charge(-1);
            });

            String expectedException = "input must be a positive integer";

            assertEquals(exception.getMessage(), expectedException);
        }

        @Test
        @DisplayName("charging with 0")
        void charge_whenInputIsZero_thenNothingHappen() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                battery.charge(0);
            });

            String expectedException = "input must be a positive integer";

            assertEquals(exception.getMessage(), expectedException);
        }

        @Test
        @DisplayName("Test that charging above the max is not possible")
        void testChargingAboveTheMax() {
            battery.charge(MAX_CHARGE + 1);
            assertEquals(MAX_CHARGE, battery.getCharge());
            battery.charge(MAX_CHARGE);
            assertEquals(MAX_CHARGE, battery.getCharge());
        }
    }

    @Nested
    @DisplayName("getChargePercentage method")
    class getChargePercentageTest {
        @Test
        @DisplayName("when called return correct percentage")
        void getChargePercentage_whenCalled_returnCorrectPercentage() {
            assertEquals(0.0, battery.getChargePercentage());
            battery.charge(MAX_CHARGE / 2);
            assertEquals(50.0, battery.getChargePercentage());
            battery.charge(MAX_CHARGE / 2);
            assertEquals(100.0, battery.getChargePercentage());
        }
    }
}