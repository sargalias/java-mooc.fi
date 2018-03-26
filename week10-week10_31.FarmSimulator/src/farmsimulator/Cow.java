package farmsimulator;

import java.util.Random;

public class Cow implements Milkable, Alive {
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
    private int capacity = 15 + new Random().nextInt(26);
    private double amount = 0;
    private String name;

    public Cow(String name) {
        this.name = name;
    }

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amount) + "/" + capacity;
    }

    @Override
    public void liveHour() {
        Random random = new Random();
        this.amount += random.nextDouble() * 1.3 + 0.7;
        this.amount = Math.min(this.capacity, this.amount);
    }

    @Override
    public double milk() {
        double milkTaken = this.amount;
        this.amount = 0;
        return milkTaken;
    }
}
