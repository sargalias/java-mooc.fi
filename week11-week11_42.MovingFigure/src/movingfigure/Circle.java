package movingfigure;

import java.awt.*;

public class Circle extends Figure {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(getX(), getY(), radius, radius);
    }
}
