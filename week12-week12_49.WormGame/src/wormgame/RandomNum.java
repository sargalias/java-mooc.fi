package wormgame;

import java.util.Random;

public class RandomNum {
    private static final Random random = new Random();

    public static int randRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
