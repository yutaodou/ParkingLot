package parkinglot;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... lots) {
        super(lots);
    }

    @Override
    protected Optional<ParkingLot> getNextParkingLot() {
        return Stream.of(getParkingLots())
                .max(Comparator.comparing(ParkingLot::getAvaiableLotCount));
    }
}
