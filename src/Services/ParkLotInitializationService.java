package Services;

import Models.*;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class ParkLotInitializationService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;
    private VehicleRepository vehicleRepository;
    public ParkLotInitializationService(GateRepository gateRepository,
                                        ParkingLotRepository parkingLotRepository,
                                        TicketRepository ticketRepository,
                                        VehicleRepository vehicleRepository){

        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
        this.vehicleRepository =vehicleRepository;
    }
    public ParkingLot init(){
        System.out.println("***********Parking Lot Initialization***********");
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setCapacity(100);
        // Gate initialization is starting for Entry Gate
        List<Gate> gateList = new ArrayList<>();
        Gate EntryGate = new Gate();
        EntryGate.setId(1);
        EntryGate.setGetNumber(1);
        Operator operatorEntry = new Operator();
        operatorEntry.setName("MAYANK");
        EntryGate.setCurrOperator(operatorEntry);
        EntryGate.setGateType(GateType.ENTRY);
        EntryGate.setGateStatus(GateStatus.OPEN);
        gateList.add(EntryGate);
        gateRepository.put(EntryGate);
        // Gate initialization is starting for Exit Gate
        Gate ExitGate = new Gate();
        ExitGate.setId(2);
        ExitGate.setGetNumber(2);
        Operator operatorExit = new Operator();
        operatorExit.setName("PIKU");
        ExitGate.setCurrOperator(operatorExit);
        ExitGate.setGateType(GateType.EXIT);
        ExitGate.setGateStatus(GateStatus.OPEN);
        gateList.add(ExitGate);
        gateRepository.put(ExitGate);
        parkingLot.setGates(gateList);
        // Parking Floor initialization is starting for Exit Gate
        List<ParkingFloor> parkingFloorList = new ArrayList<>();

        for(int i = 1; i<= 10; i++){
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setFloorNumber(i);
            List<ParkingSpot> parkingSpotList = new ArrayList<>();

            for(int j =1; j<=10; j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setParkSpotNumber((i * 100)+ j);
                parkingSpot.setParkSpotStatus(ParkSpotStatus.AVAILABLE);
                parkingSpotList.add(parkingSpot);
                parkingSpot.setVehicleTypes(List.of(VehicleType.CAR,VehicleType.BIKE,VehicleType.SUV,VehicleType.OTHER));
            }
            parkingFloor.setParkingSpots(parkingSpotList);
            parkingFloorList.add(parkingFloor);
        }
        parkingLot.setParkingFloors(parkingFloorList);
        parkingLotRepository.put(parkingLot);
        return parkingLot;
    }
}
