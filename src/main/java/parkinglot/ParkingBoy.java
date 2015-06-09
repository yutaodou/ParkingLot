package parkinglot;

import java.util.Optional;
import java.util.function.Function;

public class ParkingBoy {

    private final ParkingLot[] parkingLots;
    protected Function<ParkingLot[], Optional<ParkingLot>> parkingStrategy;

    public ParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
        parkingStrategy = ParkingStrategy.FIRST_AVAILABLE;
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

    private Optional<ParkingLot> getNextParkingLot() {
        return parkingStrategy.apply(getParkingLots());
    }
}
