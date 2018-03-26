package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.RandomNum;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;

    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        worm = new Worm(width/2, height/2, Direction.DOWN);
        createRandomApple();

        addActionListener(this);
        setInitialDelay(2000);

    }

    public void createRandomApple() {
        while (true) {
            apple = new Apple(RandomNum.randRange(0, width), RandomNum.randRange(0, height));
            if (!worm.runsInto(apple)) {
                break;
            }
        }
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }


    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            createRandomApple();
        }
        if (worm.runsIntoItself()) {
            continues = false;
        }
        Piece wormHead = worm.getPieces().get(worm.getLength()-1);
        if (wormHead.getX() < 0 || wormHead.getX() >= width) {
            continues = false;
        }
        if (wormHead.getY() < 0 || wormHead.getY() >= height) {
            continues = false;
        }
        updatable.update();
        setDelay(1000 / worm.getLength());
    }

}
