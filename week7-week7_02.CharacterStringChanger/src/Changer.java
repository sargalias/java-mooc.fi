import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> changers = new ArrayList<Change>();

    public void addChange(Change change) {
        changers.add(change);
    }

    public String change(String characterString) {
        for (Change changeObj : this.changers) {
            characterString = changeObj.change(characterString);
        }
        return characterString;

    }
}
