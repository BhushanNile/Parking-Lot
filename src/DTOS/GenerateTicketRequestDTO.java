package DTOS;

import Models.VehicleType;

public class GenerateTicketRequestDTO {
    private String VehicleNumber;
    private VehicleType vehicleType;
    private int GateId;

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getGateId() {
        return GateId;
    }

    public void setGateId(int gateId) {
        GateId = gateId;
    }
}
