package personnel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Employees {
    List<Person> people = new ArrayList<Person>();

    public void add (Person person) {
        people.add(person);
    }

    public void add(List<Person> people) {
        this.people.addAll(people);
    }

    public void print() {
        for (Iterator<Person> it=people.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }
    }

    public void print(Education education) {
        for (Iterator<Person> it=people.iterator(); it.hasNext();) {
            Person person = it.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            if (person.getEducation() == education) {
                it.remove();
            }
        }
    }
}
