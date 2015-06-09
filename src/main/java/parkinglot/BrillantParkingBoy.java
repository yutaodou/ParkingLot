package parkinglot;

import java.util.Optional;

public class BrillantParkingBoy extends ParkingBoy {
    public BrillantParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<ParkingLot> getNextParkingLot() {
        return ParkingStrategy.LOWEST_UTILIZATION_RATE.apply(getParkingLots());
    }
}
