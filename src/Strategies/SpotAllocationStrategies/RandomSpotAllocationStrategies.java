package Strategies.SpotAllocationStrategies;

import Models.*;

import java.util.Optional;

public class RandomSpotAllocationStrategies implements SpotAllocationStrategies {
    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate) {
        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkSpotStatus().equals(ParkSpotStatus.AVAILABLE) &&
                        parkingSpot.getVehicleTypes().contains(vehicleType)) {
                   return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();

    }


}

