package parkinglot;

public class ParkingLot {

    private final int capacity;
    private int occupied;

    public ParkingLot(int capacity, int occupied) {

        this.capacity = capacity;
        this.occupied = occupied;
    }

    public boolean canPark() {
        return this.capacity - this.occupied > 0;
    }

    public int getOccupied() {
        return occupied;
    }

    public void park(Car car) {
        this.occupied++;
    }

    public void unpark(Car car) {
        this.occupied--;
    }
}