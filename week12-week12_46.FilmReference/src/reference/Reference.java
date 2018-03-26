package reference;

import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.comparator.SimilarityComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person) {
        Film f = recommendFilmSimilar(person);
        if (f != null) {
            return f;
        }
        return recommendFilmDefault(person);
    }

    private Film recommendFilmDefault(Person person) {
        Map<Film, List<Rating>> allRatings = ratingRegister.filmRatings();
        List<Film> allFilms = new ArrayList<Film>(allRatings.keySet());
        Collections.sort(allFilms, new FilmComparator(allRatings));
        for (Film f : allFilms) {
            if (ratingRegister.getRating(person, f) == Rating.NOT_WATCHED) {
                return f;
            }
        }
        return null;
    }

    private Film recommendFilmSimilar(Person person) {
        Map<Film, Rating> personalRatings = ratingRegister.getPersonalRatings(person);
        if (personalRatings.isEmpty()) {
            return null;
        }

        List<Person> people = ratingRegister.reviewers();
        people.remove(person);
        Map<Person, Integer> similarityRatings = similarityRatings(person);

        Collections.sort(people, new SimilarityComparator(similarityRatings));

        return filmPersonalRecommendation(person, people);
    }

    private Map<Person, Integer> similarityRatings(Person person) {
        Map<Person, Integer> similarityRatings = new HashMap<Person, Integer>();

        for (Person otherPerson: ratingRegister.reviewers()) {
            if (person.equals(otherPerson)) {
                continue;
            }
            similarityRatings.put(otherPerson, calculateSimilarity(person, otherPerson));
        }
        return similarityRatings;
    }

    private int calculateSimilarity(Person p1, Person p2) {
        int similarity = 0;
        Map<Film, Rating> personalRatings = ratingRegister.getPersonalRatings(p1);
        Map<Film, Rating> otherPersonRatings = ratingRegister.getPersonalRatings(p2);

        for (Film f : personalRatings.keySet()) {
            if (otherPersonRatings.get(f) != null) {
                similarity += personalRatings.get(f).getValue() * otherPersonRatings.get(f).getValue();
            }
        }
        return similarity;
    }

    private Film filmPersonalRecommendation(Person person, List<Person> people) {
        for (Person p : people) {
            Map<Film, Rating> personalRecommendations = ratingRegister.getPersonalRatings(p);
            for (Film f : personalRecommendations.keySet()) {
                // Skip watched films
                if (ratingRegister.getRating(person, f) != Rating.NOT_WATCHED) {
                    continue;
                }
                // Skip films with value less than 0
                if (personalRecommendations.get(f).getValue() > 0) {
                    return f;
                }
            }
        }
        return null;
    }

}
