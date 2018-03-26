package containers;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ContainerHistory {
    private List<Double> history = new ArrayList<Double>();

    public void add(double situation) {
        this.history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }

    public double maxValue() {
        return Collections.max(history);
    }

    public double minValue() {
        return Collections.min(history);
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (double a : history) {
            sum += a;
        }
        return sum / history.size();
    }

    public double greatestFluctuation() {
        if (history.size() <= 1) {
            return 0;
        }
        double biggest = 0;
        double prev = history.get(0);
        for (double a : history) {
            double diff = Math.abs(a - prev);
            if (diff > biggest) {
                biggest = diff;
            }
            prev = a;
        }
        return biggest;
    }

    public double variance() {
        double avg = average();
        double sum = 0;
        for (double x : history) {
            sum += Math.pow(x - avg, 2);
        }
        return sum / (history.size()-1);
    }
}
