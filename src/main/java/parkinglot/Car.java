package parkinglot;

public class Car {
    private ParkingLot parkingLot;

    public void park(ParkingLot parkingLot) {
        if(isParked()) {
            throw new CarParkingException("Already parked.");
        }

        parkingLot.park(this);
        this.parkingLot = parkingLot;
    }

    public void leave() {
        if(!isParked()) {
            throw new CarParkingException("Not parked yet!");
        }

        this.parkingLot.unpark(this);
        this.parkingLot = null;
    }

    public boolean isParked() {
        return (parkingLot != null);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }
}
