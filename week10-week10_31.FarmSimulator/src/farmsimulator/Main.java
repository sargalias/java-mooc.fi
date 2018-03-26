package farmsimulator;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());
        System.out.println(farm);
    }
}
