package parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    private Car car;
    ParkingLot parkingLot;


    @Before
    public void setUp() throws Exception {
        car = new Car();
        parkingLot = new ParkingLot(1, 0);
    }

    @Test
    public void testPark() throws Exception {
        car.park(parkingLot);

        assertThat(car.isParked(), is(true));
    }

    @Test
    public void testLeave() throws Exception {
        car.park(parkingLot);
        car.leave();

        assertThat(car.isParked(), is(false));
    }

    @Test( expected = CarParkingException.class)
    public void testShouldThrowCarParkingExceptionIfParked() throws Exception {
        car.park(parkingLot);
        car.park(parkingLot);
    }

    @Test( expected = CarParkingException.class)
    public void testShouldThrowCarParkingExceptionIfUnParked() throws Exception {
        car.leave();
    }
}