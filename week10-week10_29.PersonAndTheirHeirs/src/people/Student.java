package people;

public class Student extends Person {
    private int credits = 0;

    public Student(String name, String address) {
        super(name, address);
    }

    public void study() {
        this.credits++;
    }

    public int credits() {
        return this.credits;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n")
                .append("  ")
                .append("credits ")
                .append(this.credits);
        return sb.toString();
    }
}
