package dungeon.domain;

public abstract class Movable {
    protected int x;
    protected int y;

    public Movable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean collide(Movable other) {
        return x == other.getX() && y == other.getY();
    }

    public boolean collide(int[] coords) {
        return x == coords[0] && y == coords[1];
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
