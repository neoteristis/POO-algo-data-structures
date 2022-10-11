package fr.epu.bicycle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Fleet {
    private List<Vehicle> vehicleArray;

    public Fleet() {
        this.vehicleArray = new ArrayList<>();
    }

    public int getSize() {
        return this.vehicleArray.size();
    }

    public void addVehicle(Vehicle trackable) {
        vehicleArray.add(trackable);
    }

    public int getEBikeCount() {
        int counter = 0;
        for (Vehicle vehicle: vehicleArray) {
            if (vehicle instanceof EBike) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Calculate the number of electric vehicles in a radius around a specific point
     * @return
     */
    public List<Vehicle> around(Position center, double radius) {
        ArrayList<Vehicle> vehiclesAround = new ArrayList<>();
        // Loop over all the vehicles in the array
        for (Vehicle vehicle: vehicleArray) {
            if (vehicle.isBorrowable()) {
                // Get the Optional position of the vehicle
                Optional<Position> optionalPosition = vehicle.getPosition();

                // Verify that there is a position in the Optional
                // If the vehicle position is close enough to the center, add it to the vehicles array
                if (optionalPosition.isPresent()) {
                    Position position = optionalPosition.get();
                    if (center.distance(position) <= radius) {
                        vehiclesAround.add(vehicle);
                    }
                }
            }
        }
        return vehiclesAround;
    }
}
