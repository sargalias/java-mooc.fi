package clicker.applicationlogic;

public class PersonalCalculator implements Calculator {
    private int count = 0;

    @Override
    public void increase() {
        count++;
    }

    @Override
    public int giveValue() {
        return count;
    }
}
