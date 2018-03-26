import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// add an index later

public class Search {
    private Index index = new Index();
    private List<Person> people = new ArrayList<Person>();

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public Person findByName(String name) {
        for (Person person : this.people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public Person findByNumber(String number) {
        for (Person person : this.people) {
            if (person.hasNumber(number)) {
                return person;
            }
        }
        return null;
    }

    public void clearInformation(String name) {
        Person person = findByName(name);
        if (person != null) {
            this.people.remove(person);
        }
    }

    public List<Person> findAll(String term) {
        List<Person> people = new ArrayList<Person>();
        for (Person person : this.people) {
            if (person.getName() != null && person.getName().contains(term)) {
                people.add(person);
            } else if (person.getAddress() != null && person.getAddress().contains(term)) {
                people.add(person);
            }
        }
        Collections.sort(people);
        return people;
    }
}
