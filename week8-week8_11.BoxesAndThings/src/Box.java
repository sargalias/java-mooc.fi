import java.util.ArrayList;

public class Box implements ToBeStored {
    private double maxWeight;
    private ArrayList<ToBeStored> things = new ArrayList<ToBeStored>();

    public Box(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void add(ToBeStored thing) {
        if (this.maxWeight >= weight() + thing.weight()) {
            things.add(thing);
        }
    }

    public double weight() {
        double totalWeight = 0;
        for (ToBeStored thing : this.things) {
            totalWeight += thing.weight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.things.size() +
                " things, total weight " +
                weight() + " kg";
    }

}
