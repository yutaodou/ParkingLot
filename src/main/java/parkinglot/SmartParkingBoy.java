package parkinglot;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... lots) {
        super(lots);
        parkingStrategy = ParkingStrategy.MOST_AVAILABLE_LOTS;
    }
}
