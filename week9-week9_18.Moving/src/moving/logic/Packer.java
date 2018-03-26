package moving.logic;
import moving.domain.Box;
import moving.domain.Thing;

import moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

public class Packer {
    private int boxesVolume;

    public Packer(int boxesVolume) {
        this.boxesVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things) {
        List<Box> boxes = new ArrayList<Box>();
        Box currentBox = new Box(this.boxesVolume);
        boxes.add(currentBox);
        for (Thing thing : things) {
            if (!currentBox.addThing(thing)) {
                currentBox = new Box(this.boxesVolume);
                boxes.add(currentBox);
                currentBox.addThing(thing);
            }
        }
        return boxes;
    }
}
