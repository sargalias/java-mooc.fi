public class Calculator {
    private int currentVal;

    public Calculator(int currentVal) {
        this.currentVal = currentVal;
    }

    public void plus(int val) {
        currentVal += val;
    }

    public void minus(int val) {
        currentVal -= val;
    }

    public void reset() {
        currentVal = 0;
    }

    public int getVal() {
        return currentVal;
    }
}
