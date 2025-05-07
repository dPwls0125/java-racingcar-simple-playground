import java.util.Random;

public class Car implements Movable {

    private final String name;
    private int distance;
    private static final Random random = new Random();

    public Car(String name) {
        this.name = name;
        distance = 0;
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
}
