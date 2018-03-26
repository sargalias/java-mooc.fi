import java.lang.reflect.Array;
import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private int maxWeight;
    private int currentWeight = 0;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addThing(Thing thing) {
        if (this.currentWeight + thing.getWeight() <= maxWeight) {
            this.things.add(thing);
            this.currentWeight += thing.getWeight();
        }
    }

    @Override
    public String toString() {
        String str = "";
        int numThings = this.things.size();
        if (numThings == 0) {
            str += "empty";
        } else {
            str += numThings + ((numThings == 1) ? "thing" : "things");
        }
        str += " (" + this.currentWeight + " kg)";
        return str;
    }

    public void printThings() {
        for (Thing thing : this.things) {
            System.out.println(thing);
        }
    }

    public int totalWeight() {
        return this.currentWeight;
    }

    public Thing heaviestThing() {
        if (this.things.size() == 0) {
            return null;
        }
        Thing heaviestThing = this.things.get(0);
        for (Thing currentThing : this.things) {
            if (currentThing.getWeight() > heaviestThing.getWeight()) {
                heaviestThing = currentThing;
            }
        }
        return heaviestThing;

    }

}
