package movingfigure;

import java.awt.*;

public class Square extends Figure {
    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics graphics) {
        int halfSide = sideLength/2;
        graphics.fillRect(getX(), getY(), sideLength, sideLength);
    }
}
