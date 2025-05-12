package domain;

import java.util.Objects;

public class Car {
    private final CarName carName;
    private int distance;
    private final int MOVABLE_NUMBER = 3;
    private final int MOVING_PACE = 1;

    public Car(CarName carName) {
        this.carName = carName;
        distance = 0;
    }

    public Car(CarName carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public void move(int number) {
        if (number > MOVABLE_NUMBER) {
            distance += MOVING_PACE;
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getDistance() {
        return distance;
    }

    public Car getDeepCopy() {
        Car car = new Car(this.carName, this.distance);
        return car;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car car)) return false;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
