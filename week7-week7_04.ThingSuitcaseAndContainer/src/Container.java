import java.util.ArrayList;

public class Container {
    private ArrayList<Suitcase> suitcases = new ArrayList<Suitcase>();
    private int currentWeight = 0;
    private int maxWeight;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (currentWeight + suitcase.totalWeight() <= this.maxWeight) {
            suitcases.add(suitcase);
            currentWeight += suitcase.totalWeight();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + this.currentWeight + " kg)";
    }

    public void printThings() {
        for (Suitcase suitcase : suitcases) {
            suitcase.printThings();
        }
    }
}
