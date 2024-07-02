package Models;

import java.util.Date;

public class Bill extends BaseModel {
    private Date ExitTime;
    private int Amount;
    private Ticket ticket;
    private Operator CurrentOperator;
    private Gate gate;

    public Date getExitTime() {
        return ExitTime;
    }

    public void setExitTime(Date exitTime) {
        ExitTime = exitTime;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Operator getCurrentOperator() {
        return CurrentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        CurrentOperator = currentOperator;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
