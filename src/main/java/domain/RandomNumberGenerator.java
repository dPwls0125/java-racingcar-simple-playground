package domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();

    public static int getRandomNumberFrom0To9() {
        return random.nextInt(10);
    }
}
