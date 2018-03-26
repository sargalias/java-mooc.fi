package reference.comparator;

import reference.domain.Person;

import java.util.Comparator;
import java.util.Map;

public class SimilarityComparator implements Comparator<Person> {
    private Map<Person, Integer> similarities;

    public SimilarityComparator(Map<Person, Integer> similarities) {
        this.similarities = similarities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return similarities.get(o2) - similarities.get(o1);
    }
}
