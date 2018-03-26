package people;

public class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n")
                .append("  ")
                .append("salary ")
                .append(this.salary)
                .append(" euros/month");
        return sb.toString();
    }

}
