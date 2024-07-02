package Models;

public class Gate extends BaseModel{
    private int getNumber;
    private Operator CurrOperator;
    private GateStatus gateStatus;
    private GateType gateType;

    public int getGetNumber() {
        return getNumber;
    }

    public void setGetNumber(int getNumber) {
        this.getNumber = getNumber;
    }

    public Operator getCurrOperator() {
        return CurrOperator;
    }

    public void setCurrOperator(Operator currOperator) {
        CurrOperator = currOperator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }
}
