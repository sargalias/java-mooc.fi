package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume = 0;

    public BulkTank(double capacity) {
        this.capacity = capacity;
    }

    public BulkTank() {
        this(2000);
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return capacity - volume;
    }

    public void addToTank(double amount) {
        volume = Math.min(capacity, volume+amount);
    }

    public double getFromTank(double amount) {
        if (amount > volume) {
            amount = volume;
        }
        volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
