package parkinglot;

public class Car {
    private ParkingLot parkingLot;

    public void park(ParkingLot parkingLot) {
        parkingLot.park(this);
        this.parkingLot = parkingLot;
    }

    public void leave() {
        this.parkingLot.unpark(this);
        this.parkingLot = null;
    }

    public boolean isParked() {
        return (parkingLot != null);
    }
}
