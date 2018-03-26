package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return this.tank;
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.robot = robot;
        robot.setBulkTank(this.tank);
    }

    public void takeCareOf(Cow cow) throws IllegalStateException {
        if (this.robot == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
        this.robot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) throws IllegalStateException {
        for (Cow cow : cows) {
            takeCareOf(cow);
        }
    }

    @Override
    public String toString() {
        return this.tank.toString();
    }
}
