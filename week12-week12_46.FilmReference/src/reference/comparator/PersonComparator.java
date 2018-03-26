package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIDs;

    public  PersonComparator(Map<Person, Integer> peopleIDs) {
        this.peopleIDs = peopleIDs;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return peopleIDs.get(o2) - peopleIDs.get(o1);
    }
}
