package Services;

import Models.*;
import Repositories.GateRepository;
import Exception.InvalidGateException;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import Strategies.SpotAllocationStrategies.SpotAllocationStrategies;
import Exception.NoAvailableSpotException;
import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAllocationStrategies spotAllocationStrategies;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository, SpotAllocationStrategies spotAllocationStrategies,TicketRepository ticketRepository,
                         ParkingLotRepository parkingLotRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAllocationStrategies = spotAllocationStrategies;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
    }
    public Ticket generateTicket(int gateId, VehicleType vehicleType,String VehicleNumber) throws InvalidGateException, NoAvailableSpotException {
        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);
        if(gateOptional.isEmpty()){
            throw new InvalidGateException();
        }
        Gate gate = gateOptional.get();
        Operator operator = gateOptional.get().getCurrOperator();
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleNumber(VehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(VehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.saveVehicle(vehicle);
        }else {
            vehicle = vehicleOptional.get();
        }
        Optional<ParkingLot> parkingLotOptional =parkingLotRepository.getParkingLotOfGate(gate);
        ParkingLot parkingLot = parkingLotOptional.get();
        Optional<ParkingSpot> parkingSpotOptional = spotAllocationStrategies.findSpot(vehicleType,parkingLot,gate);
        if(parkingSpotOptional.isEmpty())
        {
            throw new NoAvailableSpotException();
        }
        ParkingSpot parkingSpot = parkingSpotOptional.get();
        parkingSpot.setParkSpotStatus(ParkSpotStatus.UNAVAILABLE);
        //Todo
        Ticket ticket = new Ticket();
        ticket.setParkingSpot(parkingSpot);

        ticket.setEntryGate(gate);
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date());
        ticket.setOperator(operator);
        return ticketRepository.saveTicket(ticket)  ;
    }

    public void TicketPrint(int id){
        Ticket ticket = ticketRepository.GetTicket(id);
        System.out.println("********Ticket********");
        System.out.println("Ticket ID:-" + ticket.getId());
        System.out.println("Parking Spot Number:-" + ticket.getParkingSpot().getParkSpotNumber());
        System.out.println("Parking Floor Number:-" + ticket.getVehicle());
        System.out.println("Entry Time:-" + ticket.getEntryTime());
    }
}
