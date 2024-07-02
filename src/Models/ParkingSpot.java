package Models;

import java.util.List;

public class ParkingSpot extends BaseModel{
    private int parkSpotNumber;
    private List<VehicleType> vehicleTypes;
    private ParkSpotStatus parkSpotStatus;
    private Vehicle vehicle;

    public int getParkSpotNumber() {
        return parkSpotNumber;
    }

    public void setParkSpotNumber(int parkSpotNumber) {
        this.parkSpotNumber = parkSpotNumber;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkSpotStatus getParkSpotStatus() {
        return parkSpotStatus;
    }

    public void setParkSpotStatus(ParkSpotStatus parkSpotStatus) {
        this.parkSpotStatus = parkSpotStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
