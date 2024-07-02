package Repositories;

import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSpot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Integer,ParkingLot> parklotMap = new TreeMap<>();
    public Optional<ParkingLot> getParkingLotOfGate(Gate gate){
        for(ParkingLot parkingLot: parklotMap.values()){
            if(parkingLot.getGates().contains(gate)){
                return Optional.of(parkingLot);
            }
        }
        return Optional.empty();
    }
    public void put(ParkingLot parkingLot){
        parklotMap.put(parkingLot.setId(1),parkingLot);
    }

}
