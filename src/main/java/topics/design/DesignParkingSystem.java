package topics.design;

//leetCode #1603
public class DesignParkingSystem {

    /*
    Design a parking system for a parking lot.
    The parking lot has three kinds of parking spaces:
    big, medium, and small, with a fixed number of slots for each size.

    Implement the ParkingSystem class:

    ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class.
    The number of slots for each parking space are given as part of the constructor.

    bool addCar(int carType)
    Checks whether there is a parking space of carType for the car that wants to get into the parking lot.
    carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively.
    A car can only park in a parking space of its carType. If there is no space available,
    return false, else park the car in that size space and return true.
     */

    private int bigSpots;
    private int mediumSpots;
    private int smallSpots;

    public DesignParkingSystem(int big, int medium, int small) {
        this.bigSpots = big;
        this.mediumSpots = medium;
        this.smallSpots = small;
    }

    public boolean addCar(int carType) {
        if (carType == 3 && smallSpots > 0) {
            smallSpots--;
            return true;
        } else if (carType == 2 && mediumSpots > 0) {
            mediumSpots--;
            return true;
        } else if (carType == 1 && bigSpots > 0) {
            bigSpots--;
            return true;
        }

        return false;
    }

}
