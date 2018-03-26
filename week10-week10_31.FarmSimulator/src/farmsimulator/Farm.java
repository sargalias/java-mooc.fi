package farmsimulator;

import java.util.List;
import java.util.ArrayList;

public class Farm {
    private String owner;
    private Barn barn;
    private List<Cow> cows = new ArrayList<Cow>();

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }

    public String getOwner() {
        return this.owner;
    }

    public void addCow(Cow cow) {
        this.cows.add(cow);
    }

    public void liveHour() {
        for (Cow cow : this.cows) {
            cow.liveHour();
        }
    }

    public void installMilkingRobot(MilkingRobot robot) {
        this.barn.installMilkingRobot(robot);
    }

    public void manageCows() {
        this.barn.takeCareOf(this.cows);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: ").append(this.owner).append("\n")
                .append("Barn bulk tank: ").append(this.barn.getBulkTank().toString()).append("\n");
        if (this.cows.isEmpty()) {
            sb.append("No cows.");
        } else {
            sb.append("Animals:\n");
            for (Cow cow : this.cows) {
                sb.append("        ");
                sb.append(cow.toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
