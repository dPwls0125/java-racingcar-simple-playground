package domain;

import java.util.Objects;

public class Car implements Movable {
    private final CarName carName;
    private int distance;

    public Car(CarName carName) {
        this.carName = carName;
        distance = 0;
    }

    public Car(CarName carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    @Override
    public void move(int randomNum) {
        if (randomNum > 3) {
            distance += 1;
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
