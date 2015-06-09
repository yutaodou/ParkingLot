package parkinglot;

import java.util.Optional;
import java.util.stream.Stream;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... lots) {
        super(lots);
    }

    @Override
    protected Optional<ParkingLot> getNextParkingLot() {
        return Stream.of(getParkingLots())
                .max((lot1, lot2) -> lot1.getAvaiableLotCount() - lot2.getAvaiableLotCount());
    }
}
