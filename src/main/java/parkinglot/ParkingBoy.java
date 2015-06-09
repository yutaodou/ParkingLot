package parkinglot;

import java.util.Optional;
import java.util.stream.Stream;

public class ParkingBoy {

    private final ParkingLot[] parkingLots;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void park(Car car) {
        Optional<ParkingLot> parkingLotOpt = getNextParkingLot();

        if (!parkingLotOpt.isPresent()) {
            throw new CarParkingException("No available parkinglot.");
        }

        car.park(parkingLotOpt.get());
    }


    public ParkingLot[] getParkingLots() {
        return parkingLots;
    }

    public Car fetch(Car car) {
        car.leave();
        return car;
    }

    protected Optional<ParkingLot> getNextParkingLot() {
        return Stream.of(parkingLots).filter(ParkingLot::canPark).findFirst();
    }
}
