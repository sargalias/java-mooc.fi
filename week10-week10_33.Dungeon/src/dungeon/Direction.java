package dungeon;

import dungeon.helpers.RandomGenerator;

import java.util.Random;

public enum Direction {
    A, S, D, W;

    private static final Random random = new Random();

    public static Direction getKey(char c) {
        switch (c) {
            case 'a':
                return A;
            case 's':
                return S;
            case 'd':
                return D;
            case 'w':
                return W;
        }
        return null;
    }

    public static Direction randomDirection() {
        int i = RandomGenerator.randRange(Direction.values().length);
        return Direction.values()[i];
    }
}
