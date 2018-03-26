import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Jump {
    private int jumpLength;
    private List<Integer> stylePoints = new ArrayList<Integer>();
    private Random random = new Random();

    private int randRange(int low, int high) {
        return random.nextInt(high-low) + 1 + low;
    }

    public Jump() {
        this.jumpLength = randRange(60, 120);
        for (int i=0; i<5; i++) {
            this.stylePoints.add(randRange(10, 20));
        }
    }

    public Jump(int jumpLength, List<Integer> stylePoints) {
        this.jumpLength = jumpLength;
        this.stylePoints = stylePoints;
    }

    public int getPoints() {
        return getStylePoints() + this.jumpLength;
    }

    private int getStylePoints() {
        int sum = 0;
        for (int points : validPointsList()) {
            sum += points;
        }
        return sum;
    }

    private List<Integer> validPointsList() {
        List<Integer> p = new ArrayList<Integer>(this.stylePoints);
        p.remove(Collections.min(p));
        p.remove(Collections.max(p));
        return p;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    length: " + this.jumpLength + "\n");
        sb.append("    judge votes: [");
        for (int i=0; i<this.stylePoints.size(); i++) {
            if (i == this.stylePoints.size()-1) {
                sb.append(this.stylePoints.get(i));
            } else {
                sb.append(this.stylePoints.get(i) + ", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
