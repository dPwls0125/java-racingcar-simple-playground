package data;

public class CarSnapShot {
    private final String carName;
    private final int distance;

    public CarSnapShot(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
