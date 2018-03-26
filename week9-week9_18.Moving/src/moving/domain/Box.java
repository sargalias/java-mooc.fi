package moving.domain;

import java.util.ArrayList;
import java.util.List;

public class Box implements Thing {
    private int maxCapacity;
    private List<Thing> things = new ArrayList<Thing>();

    public Box(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public boolean addThing(Thing thing) {
        if (getVolume() + thing.getVolume() > this.maxCapacity) {
            return false;
        }
        this.things.add(thing);
        return true;
    }

    public int getVolume() {
        int sum = 0;
        for (Thing thing : things) {
            sum += thing.getVolume();
        }
        return sum;
    }
}
