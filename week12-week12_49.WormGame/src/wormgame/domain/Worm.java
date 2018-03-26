package wormgame.domain;
import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> wormPieces = new ArrayList();
    private int currentLength;
    private int matureLength = 3;

    public Worm(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        wormPieces.add(new Piece(x, y));
        currentLength = 1;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getLength() {
        return currentLength;
    }

    public List<Piece> getPieces() {
        return wormPieces;
    }

    public void move() {
        // remove piece at end
        if (matureLength <= currentLength) {
            wormPieces.remove(0);
        } else {
            currentLength++;
        }
        // Add a piece based on direction.
        if (direction == Direction.UP) {
            y--;
        } else if (direction == Direction.DOWN) {
            y++;
        } else if (direction == Direction.LEFT) {
            x--;
        } else {
            x++;
        }
        wormPieces.add(new Piece(x, y));
    }

    public void grow() {
        if (currentLength >= matureLength) {
            matureLength++;
        }
    }

    public boolean runsInto(Piece piece) {
        for (Piece p : wormPieces) {
            if (p != piece && p.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        for (Piece piece : wormPieces) {
            if (runsInto(piece)) {
                return true;
            }
        }
        return false;
    }
}
