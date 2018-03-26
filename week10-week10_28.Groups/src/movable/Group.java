package movable;

import java.util.List;
import java.util.ArrayList;

public class Group implements Movable {
    private List<Movable> movables = new ArrayList<Movable>();

    public void addToGroup(Movable movable) {
        this.movables.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable o : this.movables) {
            o.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Movable o : this.movables) {
            sb.append(o.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
