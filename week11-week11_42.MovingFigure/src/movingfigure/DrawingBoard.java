package movingfigure;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel {
    private Figure figure;

    public DrawingBoard(Figure figure) {
        this.figure = figure;
        setBackground(Color.WHITE);
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        figure.draw(graphics);
    }
}
