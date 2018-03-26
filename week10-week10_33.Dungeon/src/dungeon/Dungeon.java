package dungeon;

import dungeon.domain.DungeonDisplay;
import dungeon.domain.Movable;
import dungeon.domain.Player;
import dungeon.domain.Vampire;
import dungeon.helpers.RandomGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Dungeon {
    private int length;
    private int height;
    private int numVampires;
    private boolean vampiresMove;
    private int movesRemaining;
    private Player player;
    private List<Movable> vampires = new ArrayList<Movable>();
    private DungeonDisplay dungeonDisplay;
    private Scanner reader = new Scanner(System.in);

    public Dungeon(int length, int height, int numVampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.numVampires = numVampires;
        this.movesRemaining = moves;
        this.vampiresMove = vampiresMove;
    }

    public void run() {
        setup();
        while (movesRemaining > 0) {
            displayFrame();
            List<Direction> moves = getPlayerMoves();
            for (int i=0; i<moves.size(); i++) {
                Direction direction = moves.get(i);
                move(direction);
            }
            movesRemaining--;
            if (vampires.isEmpty()) {
                break;
            }
        }
        if (vampires.isEmpty()) {
            System.out.println("YOU WIN");
        } else {
            System.out.println("YOU LOSE");
        }
    }

    private void move(Direction direction) {
        int[] dxdy = getDxDy(direction);
        if (isMoveOutOfBounds(player, dxdy)) {
            return;
        }
        movePlayer(dxdy);
        if (vampiresMove) {
            moveVampires();
        }
    }

    private void movePlayer(int[] dxdy) {
        player.move(dxdy[0], dxdy[1]);
        playerVampireCollisions();
    }

    private void moveVampires() {
        for (Iterator<Movable> it = vampires.iterator(); it.hasNext();) {
            Movable vampire = it.next();
            moveVampire(vampire, it);
        }
    }

    private void moveVampire(Movable vampire, Iterator<Movable> it) {
        Direction direction = Direction.randomDirection();
        int[] dxdy = getDxDy(direction);
        // generate random direction
        if (isMoveOutOfBounds(vampire, dxdy)) {
            return;
        }
        if (placeOccupiedByVampire(vampire, dxdy)) {
            return;
        }
        vampire.move(dxdy[0], dxdy[1]);
        if (player.collide(vampire)) {
            it.remove();
        }
    }

    private int[] getDxDy(Direction direction) {
        int[] dxdy = new int[2];
        if (direction == Direction.A) {
            dxdy[0] = -1;
        } else if (direction == Direction.D) {
            dxdy[0] = 1;
        } else if (direction == Direction.S) {
            dxdy[1] = 1;
        } else if (direction == Direction.W) {
            dxdy[1] = -1;
        }
        return dxdy;
    }

    private boolean placeOccupiedByVampire(Movable thisVampire, int[] dxdy) {
        int[] newCoords = {thisVampire.getX()+dxdy[0], thisVampire.getY()+dxdy[1]};
        for (Movable otherVampire : vampires) {
            if (otherVampire.collide(newCoords)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMoveOutOfBounds(Movable movable, int[] dxdy) {
        int[] newCoords = {movable.getX()+dxdy[0], movable.getY()+dxdy[1]};
        return (
                newCoords[0] < 0
                || newCoords[0] >= length
                || newCoords[1] < 0
                || newCoords[1] >= height
        );
    }


    private void playerVampireCollisions() {
        List<Movable> vampiresToRemove = new ArrayList<Movable>();
        for (Movable vampire : vampires) {
            if (player.collide(vampire)) {
                vampiresToRemove.add(vampire);
            }
        }
        vampires.removeAll(vampiresToRemove);
    }

    public List<Direction> getPlayerMoves() {
        List<Direction> moves = new ArrayList<Direction>();
        String movesStr = reader.nextLine();
        for (int i=0; i<movesStr.length(); i++) {
            Direction direction = Direction.getKey(movesStr.charAt(i));
            if (direction != null) {
                moves.add(direction);
            }
        }
        return moves;
    }

    private void setup() {
        dungeonDisplay = new DungeonDisplay(this);
        player = new Player(0, 0);
        for (int i=0; i<numVampires; i++) {
            boolean hasCollision = true;
            while (hasCollision) {
                hasCollision = false;
                Movable vampire = new Vampire(RandomGenerator.randRange(length), RandomGenerator.randRange(height));
                if (vampire.collide(player)) {
                    hasCollision = true;
                    continue;
                }
                for (Movable otherVampire : vampires) {
                    if (vampire.collide(otherVampire)) {
                        hasCollision = true;
                        break;
                    }
                }
                if (!hasCollision) {
                    vampires.add(vampire);
                    break;
                }
            }
        }
    }

    public int getMoves() {
        return movesRemaining;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public List<Movable> getVampires() {
        return vampires;
    }

    public Player getPlayer() {
        return player;
    }

    private void displayFrame() {
        dungeonDisplay.displayFrame();
    }
}
