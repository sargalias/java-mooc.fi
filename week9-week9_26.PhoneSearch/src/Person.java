import java.util.*;

public class Person implements Comparable<Person> {
    private String name;
    private List<String> numbers = new ArrayList<String>();
    private Map<String, String> address = new HashMap<String, String>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getNumbers() {
        return new ArrayList<String>(this.numbers);
    }

    public String getAddress() {
        if (this.address.size() == 0) {
            return null;
        }
        return this.address.get("street") + " " + this.address.get("city");
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void addAddress(String street, String city) {
        this.address.put("street", street);
        this.address.put("city", city);
    }

    public boolean hasNumber(String number) {
        return this.numbers.contains(number);
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
