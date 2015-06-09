package parkinglot;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class ParkingStrategy {
    public static final Function<ParkingLot[], Optional<ParkingLot>> FIRST_AVAILABLE =
            (parkingLots -> Stream
                    .of(parkingLots)
                    .filter(ParkingLot::canPark)
                    .findFirst());

    public static final Function<ParkingLot[], Optional<ParkingLot>> MOST_AVAILABLE_LOTS =
            (parkingLots -> Stream
                    .of(parkingLots)
                    .max(Comparator.comparing(ParkingLot::getAvailableLotCount)));


    public static final Function<ParkingLot[], Optional<ParkingLot>> LOWEST_UTILIZATION_RATE =
            (parkingLots -> Stream
                    .of(parkingLots)
                    .min(Comparator.comparing(ParkingLot::getUtilizationRate)));
}
