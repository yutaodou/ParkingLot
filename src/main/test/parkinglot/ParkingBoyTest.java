package parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {

    private ParkingBoy boy;
    private Car car;
    private ParkingLot lot1;
    private ParkingLot lot2;


    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(5, 1);
        lot2 = new ParkingLot(5, 2);
        boy = new ParkingBoy(lot1, lot2);

        car = new Car();
    }
    @Test
    public void testCanPark() throws Exception {
        boy.park(car);

        assertThat(car.isParked(), is(true));
        assertThat(car.getParkingLot(), is(lot1));
    }

    @Test
    public void testFetchCar() throws Exception {
        boy.park(car);
        Car fetched = boy.fetch(car);

        assertThat(fetched.isParked(), is(false));
        assertThat(fetched, is(car));
    }

    @Test( expected = CarParkingException.class)
    public void testShouldThrowsExceptionIfAllFull() throws Exception {
        lot1 = new ParkingLot(5, 5);
        lot2 = new ParkingLot(5, 5);
        boy = new ParkingBoy(lot1, lot2);

        boy.park(car);
    }
}