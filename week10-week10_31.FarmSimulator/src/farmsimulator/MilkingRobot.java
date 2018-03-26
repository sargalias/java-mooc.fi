package farmsimulator;

public class MilkingRobot {
    private BulkTank bulkTank;

    public BulkTank getBulkTank() {
        return this.bulkTank;
    }

    public void setBulkTank(BulkTank bulkTank) {
        this.bulkTank = bulkTank;
    }

    public void milk(Milkable milkable) throws IllegalStateException {
        if (this.bulkTank == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        double amount = milkable.milk();
        bulkTank.addToTank(amount);
    }
}
