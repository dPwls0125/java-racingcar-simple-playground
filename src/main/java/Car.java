import java.util.Random;

public class Car implements Movable {

    private final String name;
    private int distance;
    private static final Random random = new Random();

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
        if (name.length() > 5)
            throw new RuntimeException("이름은 5자 이하만 가능합니다. : " + name);
    }

    @Override
    public void move() {
        if (isMoveable()) {
            distance += 1;
        }
    }

    private boolean isMoveable() {
        int randomInt = random.nextInt(10);
        return randomInt > 3;
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
}
