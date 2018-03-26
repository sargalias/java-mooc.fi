import java.util.ArrayList;
import java.util.List;

public class Directory {
    private Search search = new Search();

    public void addNumber(String name, String number) {
        Person person = search.findByName(name);
        if (person == null) {
            person = new Person(name);
            person.addNumber(number);
            search.addPerson(person);
        } else {
            person.addNumber(number);
        }
    }

    public void addAddress(String name, String street, String city) {
        Person person = search.findByName(name);
        if (person == null) {
            person = new Person(name);
            person.addAddress(street, city);
            search.addPerson(person);
        } else {
            person.addAddress(street, city);
        }
    }

    public Person getPerson(String name) {
       return search.findByName(name);
    }

    public Person searchByNumber(String number) {
        return search.findByNumber(number);
    }

    public void clearInformation(String name) {
        search.clearInformation(name);
    }

    public List<Person> searchAll(String term) {
        return search.findAll(term);
    }

}
