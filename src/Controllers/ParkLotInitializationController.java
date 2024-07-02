package Controllers;

import Models.ParkingLot;
import Services.ParkLotInitializationService;

public class ParkLotInitializationController {
    private ParkLotInitializationService parkLotInitializationService;

    public ParkLotInitializationController(ParkLotInitializationService parkLotInitializationService){
        this.parkLotInitializationService = parkLotInitializationService;
    }
    public ParkingLot initi() {
        return parkLotInitializationService.init();
    }
}
