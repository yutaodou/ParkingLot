package parkinglot;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class BrillantParkingBoy extends ParkingBoy{
    public BrillantParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    protected Optional<ParkingLot> getNextParkingLot() {
        return Stream.of(getParkingLots())
                .min(Comparator.comparing(ParkingLot::getUtilizationRate));
    }

}
