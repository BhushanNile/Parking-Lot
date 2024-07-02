import Controllers.TicketController;
import DTOS.GenerateTicketRequestDTO;
import DTOS.GenerateTicketResponseDTO;
import Models.Gate;
import Models.ParkingLot;
import Models.VehicleType;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TicketRepository;
import Repositories.VehicleRepository;
import Services.ParkLotInitializationService;
import Services.TicketService;
import Strategies.SpotAllocationStrategies.RandomSpotAllocationStrategies;
import Strategies.SpotAllocationStrategies.SpotAllocationStrategies;
import Exception.NoAvailableSpotException;
import Exception.InvalidGateException;
import java.util.Scanner;

public class ParkingLotMain {
    public static void main(String[] args) throws InvalidGateException, NoAvailableSpotException {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAllocationStrategies spotAllocationStrategies = new RandomSpotAllocationStrategies();
        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                spotAllocationStrategies,
                ticketRepository,
                parkingLotRepository);
        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Parking Lot is initiated on port of : 8080");
        ParkLotInitializationService parkLotInitializationService = new ParkLotInitializationService(gateRepository,
                parkingLotRepository,ticketRepository,vehicleRepository);
        parkLotInitializationService.init();
        Scanner scanner = new Scanner(System.in);
        GenerateTicketRequestDTO generateTicketRequestDTO = new GenerateTicketRequestDTO();
        System.out.println("Please provide Vehicle Number");
        String vehicleNumber = scanner.next();
        generateTicketRequestDTO.setVehicleNumber(vehicleNumber);

        System.out.println("Please provide Vehicle Type in(CAR/SUV/BIKE/OTHER)");
        String vehicleType = scanner.next();
        if(vehicleType.equalsIgnoreCase("CAR")){
            generateTicketRequestDTO.setVehicleType(VehicleType.CAR);
        }
            GenerateTicketResponseDTO generateTicketResponseDTO = ticketController.GenerateTicket(generateTicketRequestDTO);

        ticketService.TicketPrint(generateTicketResponseDTO.getTicketId());

    }
}
