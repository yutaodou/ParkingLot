package parkinglot;

import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... lots) {
        super(lots);
    }

    @Override
    protected Optional<ParkingLot> getNextParkingLot() {
        return ParkingStrategy.MOST_AVAILABLE_LOTS.apply(getParkingLots());
    }
}
