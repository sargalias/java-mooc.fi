package containers;

public class ProductContainerRecorder extends ProductContainer {
    private ContainerHistory ch;

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        ch = new ContainerHistory();
        ch.add(initialVolume);
        super.addToTheContainer(initialVolume);
    }

    public String history() {
        return ch.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        ch.add(super.getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        amount = super.takeFromTheContainer(amount);
        ch.add(getVolume());
        return amount;
    }

    public void printAnalysis() {
        System.out.println("Product: " + super.getName());
        System.out.println("History: " + ch.toString());
        System.out.println("Greatest product amount: " + ch.maxValue());
        System.out.println("Smallest product amount: " + ch.minValue());
        System.out.println("Average: " + ch.average());
        System.out.println("Greatest change: " + ch.greatestFluctuation());
        System.out.println("Variance: " + ch.variance());
    }
}
