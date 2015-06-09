package parkinglot;

public class BrilliantParkingBoy extends ParkingBoy {

    public BrilliantParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
        parkingStrategy = ParkingStrategy.LOWEST_UTILIZATION_RATE;
    }
}
