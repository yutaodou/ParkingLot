package parkinglot;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    @Test
    public void testCannotParkWhenParkingLotIsFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5, 5);
        assertThat(parkingLot.canPark(), is(false));
    }

    @Test
    public void testCanParkWhenParkingLotIsNotFull() throws Exception {
        ParkingLot parkingLot = new ParkingLot(5, 3);
        assertThat(parkingLot.canPark(), is(true));
    }

    @Test
    public void testCanUnpark() throws Exception {

        ParkingLot parkingLot = new ParkingLot(5, 3);
        Car car = new Car();

        car.park(parkingLot);
        assertThat(parkingLot.getOccupied(), is(4));

        car.leave();
        assertThat(parkingLot.getOccupied(), is(3));
    }
}