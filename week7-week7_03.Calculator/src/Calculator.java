import java.util.ArrayList;

public class Calculator {
    private Reader reader = new Reader();
    private int calculationsDone = 0;

    public void start() {
        while (true) {
            System.out.println("Command");
            String command = this.reader.readString();
            if (command.equals("end")) {
                break;
            } else if (command.equals("sum")) {
                sum();
                addCalculation();
            } else if (command.equals("difference")) {
                difference();
                addCalculation();
            } else if (command.equals("product")) {
                product();
                addCalculation();
            }
            System.out.println();
        }
        statistics();
    }

    private void addCalculation() {
        this.calculationsDone++;
    }

    private void statistics() {
        System.out.println("Calculations done " + this.calculationsDone);
    }

    private int[] getValues() {
        int[] values = new int[2];
        for (int i=0; i<2; i++) {
            System.out.print("value" + i + ": ");
            values[i] = this.reader.readInteger();
        }
        return values;
    }

    private void sum() {
        int[] values = getValues();
        int sum = values[0] + values[1];
        System.out.println("sum of the values " + sum);
    }

    private void difference() {
        int[] values = getValues();
        int diff = values[0] - values[1];
        System.out.println("difference of the values " + diff);
    }

    private void product() {
        int[] values = getValues();
        int product = values[0] * values[1];
        System.out.println("product of the values " + product);
    }
}
