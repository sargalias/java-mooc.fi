import java.util.ArrayList;
import java.util.List;

public class Participant implements Comparable<Participant> {
    private String name;
    private List<Jump> jumpList;

    public Participant(String name) {
        this.name = name;
        this.jumpList = new ArrayList<Jump>();
    }

    public int getPoints() {
        int sum = 0;
        for (Jump jump : this.jumpList) {
            sum += jump.getPoints();
        }
        return sum;
    }

    public String getName() {
        return this.name;
    }

    public Jump getLastJump() {
        return this.jumpList.get(this.jumpList.size()-1);
    }

    public void addJump(Jump jump) {
        this.jumpList.add(jump);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        Participant other = (Participant) object;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " (" + getPoints() + " points)";
    }

    @Override
    public int compareTo(Participant other) {
        return this.getPoints() - other.getPoints();
    }
}
