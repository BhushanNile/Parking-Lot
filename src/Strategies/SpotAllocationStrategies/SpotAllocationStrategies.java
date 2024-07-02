package Strategies.SpotAllocationStrategies;

import Models.*;

import java.util.Optional;

public interface SpotAllocationStrategies {
    Optional<ParkingSpot> findSpot(VehicleType vehicleType, ParkingLot parkingLot, Gate gate);
}
