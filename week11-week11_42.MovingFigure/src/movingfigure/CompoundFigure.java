package movingfigure;

import java.awt.*;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class CompoundFigure extends Figure {
    List<Figure> figures = new ArrayList<Figure>();

    public CompoundFigure() {
        super(0, 0);
    }

    public CompoundFigure(int x, int y) {
        super(x, y);
    }

    public void add(Figure figure) {
        figures.add(figure);
    }

    @Override
    public void draw(Graphics graphics) {
        for (Figure figure : figures) {
            figure.draw(graphics);
        }
    }

    @Override
    public void move(int dx, int dy) {
        for (Figure figure : figures) {
            figure.move(dx, dy);
        }
    }
}
