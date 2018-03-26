package game;
import gameoflife.Board;
import gameoflife.GameOfLifeBoard;

import java.util.Random;

public class PersonalBoard extends GameOfLifeBoard {

    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight();
    }

    @Override
    public void turnToLiving(int x, int y) {
        if (isInBounds(x, y)) {
            getBoard()[x][y] = true;
        }
    }

    @Override
    public void turnToDead(int x, int y) {
        if (isInBounds(x, y)) {
            getBoard()[x][y] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        if (!isInBounds(x, y)) {
            return 0;
        }
        int count = 0;
        for (int i=-1; i<=1; i++) {
            for (int j=-1; j<=1; j++) {
                if (i==0 && j==0) {
                    continue;
                } else if (isAlive(x+i, y+j)) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean isAlive(int x, int y) {
        if (isInBounds(x, y)) {
            return getBoard()[x][y];
        }
        return false;
    }

    @Override
    public void initiateRandomCells(double probability) {
        Random random = new Random();
        boolean[][] board = getBoard();
        for (int x=0; x<getWidth(); x++) {
            for (int y=0; y<getHeight(); y++) {
                if (random.nextDouble() < probability) {
                    board[x][y] = true;
                } else {
                    board[x][y] = false;
                }
            }
        }
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        if (livingNeighbours < 2 || livingNeighbours > 3) {
            turnToDead(x, y);
        } else if (livingNeighbours == 3) {
            turnToLiving(x, y);
        }
    }
}
