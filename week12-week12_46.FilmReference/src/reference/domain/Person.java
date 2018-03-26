package reference.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Person other = (Person) object;
        return other.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
