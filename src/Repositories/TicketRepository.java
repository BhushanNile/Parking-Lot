package Repositories;

import Models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {
    private Map<Integer,Ticket> ticketMap = new TreeMap<>();
    private int lstSaveId =0;
    public Ticket saveTicket(Ticket ticket){
        ticket.setId(lstSaveId+1);
        lstSaveId +=1;
        ticketMap.put(lstSaveId,ticket);
        return ticket;

    }
    public Ticket GetTicket(int id){
        if(ticketMap.containsKey(id))
        {
            return ticketMap.get(id);
        }
        return null;
    }


}
