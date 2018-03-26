package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawingBoard extends JPanel implements Updatable {
    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.BLACK);
        drawWorm(graphics);

        graphics.setColor(Color.RED);
        drawApple(graphics);
    }

    public void drawApple(Graphics graphics) {
        Apple apple = wormGame.getApple();
        graphics.fillOval(
                apple.getX()*pieceLength,
                apple.getY()*pieceLength,
                pieceLength,
                pieceLength
        );
    }

    public void drawWorm(Graphics graphics) {
        List<Piece> wormPieces = this.wormGame.getWorm().getPieces();
        for (Piece p : wormPieces) {
            graphics.fill3DRect(
                    p.getX()*pieceLength,
                    p.getY()*pieceLength,
                    pieceLength,
                    pieceLength,
                    false
            );
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
