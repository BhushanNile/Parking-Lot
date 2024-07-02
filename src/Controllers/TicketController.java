package Controllers;

import DTOS.GenerateTicketRequestDTO;
import DTOS.GenerateTicketResponseDTO;
import DTOS.ResponseStatus;
import Models.Ticket;
import Models.VehicleType;
import Services.TicketService;
import Exception.InvalidGateException;
import Exception.NoAvailableSpotException;

import java.util.Scanner;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }
    public GenerateTicketResponseDTO GenerateTicket(GenerateTicketRequestDTO requestDTO) throws InvalidGateException, NoAvailableSpotException {
         String VehicleNumber =requestDTO.getVehicleNumber();
         VehicleType vehicleType = requestDTO.getVehicleType();
         requestDTO.setGateId(1);

         Ticket ticket = ticketService.generateTicket(requestDTO.getGateId(),vehicleType,VehicleNumber );
         GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
         responseDTO.getResponseStatus(ResponseStatus.SUCCESSFUL);
         responseDTO.setTicketId(ticket.getId());
         responseDTO.setOperatorName(ticket.getOperator().getName());
         responseDTO.getSpotNumber(ticket.getParkingSpot().getParkSpotNumber());
        return responseDTO;

    }

}
