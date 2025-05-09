package domain;

import java.util.Random;

public class Car implements Movable {
    private final String name;
    private int distance;


    public Car(String name) {
        validateCarName(name);
        this.name = name;
        distance = 0;
    }

    public Car(String name, int distance) {
        validateCarName(name);
        this.name = name;
        this.distance = distance;
    }

    private void validateCarName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        if (name.length() > 5) {
            throw new InvalidLengthUserNameException("이름은 5자까지 가능합니다.");
        }
    }

    @Override
    public void move(int randomNum) {
        if (randomNum > 3) {
            distance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car getDeepCopy() {
        Car car = new Car(this.name, this.distance);
        return car;
    }

    static class InvalidLengthUserNameException extends IllegalArgumentException {
        InvalidLengthUserNameException(String errorMessage) {
            super(errorMessage);
        }
    }
}
