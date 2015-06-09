package parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car();
    }

    @Test
    public void testPark() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1, 0);
        car.park(parkingLot);

        assertThat(car.isParked(), is(true));
    }

    @Test
    public void testLeave() throws Exception {
        ParkingLot lot = new ParkingLot(1, 0);

        car.park(lot);
        car.leave();

        assertThat(car.isParked(), is(false));
    }
}