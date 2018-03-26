package dungeon.helpers;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public static int randRange(int min, int max) {
        return random.nextInt(max-min) + min;
    }

    public static int randRange(int max) {
        return randRange(0, max);
    }
}
