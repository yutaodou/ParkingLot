package parkinglot;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BrilliantParkingBoyTest {
    private ParkingBoy boy;
    private Car car;
    private ParkingLot lot1;
    private ParkingLot lot2;


    @Before
    public void setUp() throws Exception {
        lot1 = new ParkingLot(100, 40);
        lot2 = new ParkingLot(10, 0);
        boy = new ParkingBoy(new ParkingLot[]{lot1, lot2}, ParkingStrategy.LOWEST_UTILIZATION_RATE);

        car = new Car();
    }

    @Test
    public void testShouldParkToTheOneWithLowestUsage() throws Exception {
        boy.park(car);

        assertThat(car.isParked(), is(true));
        assertThat(car.getParkingLot(), is(lot2));

    }
}

