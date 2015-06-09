package parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SmartParkingBoyTest {

    private ParkingBoy boy;
    private Car car;
    private ParkingLot lot1;
    private ParkingLot lot2;


    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(5, 2);
        lot2 = new ParkingLot(5, 1);
        boy = new ParkingBoy(new ParkingLot[]{lot1, lot2}, ParkingStrategy.MOST_AVAILABLE_LOTS);

        car = new Car();
    }

    @Test
    public void testParkCar() throws Exception {
        boy.park(car);

        assertThat(car.getParkingLot(), is(lot2));
        assertThat(car.isParked(), is(true));
    }

    @Test
    public void testParkToFirstParkingLotIfHaveSameAvailableLots() throws Exception {
        lot1 = new ParkingLot(5, 2);
        lot2 = new ParkingLot(5, 2);
        boy = new ParkingBoy(new ParkingLot[]{lot1, lot2}, ParkingStrategy.MOST_AVAILABLE_LOTS);

        boy.park(car);
        assertThat(car.getParkingLot(), is(lot1));
        assertThat(car.isParked(), is(true));
    }
}