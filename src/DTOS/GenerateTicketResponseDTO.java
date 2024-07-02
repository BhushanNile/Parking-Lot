package DTOS;

public class GenerateTicketResponseDTO {
    private int TicketId;
    private String OperatorName;
    private int SpotNumber;
    private ResponseStatus responseStatus;
    public int getTicketId() {
        return TicketId;
    }

    public ResponseStatus getResponseStatus(ResponseStatus successful) {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public void setTicketId(int ticketId) {
        TicketId = ticketId;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public int getSpotNumber(int parkSpotNumber) {
        return SpotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        SpotNumber = spotNumber;
    }




}
