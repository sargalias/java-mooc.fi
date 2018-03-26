package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private Map<Film, List<Rating>> filmRatings = new HashMap<Film, List<Rating>>();
    private Map<Person, Map<Film, Rating>> peopleRatings = new HashMap<Person, Map<Film, Rating>>();

    public void addRating(Film film, Rating rating) {
        filmRatings.putIfAbsent(film, new ArrayList<Rating>());
        filmRatings.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }

    public void addRating(Person person, Film film, Rating rating) {
        peopleRatings.putIfAbsent(person, new HashMap<Film, Rating>());
        if (peopleRatings.get(person).get(film) == null) {
            peopleRatings.get(person).put(film, rating);
            addRating(film, rating);
        }
    }

    public Rating getRating(Person person, Film film) {
        if (peopleRatings.get(person) != null) {
            if (peopleRatings.get(person).get(film) != null) {
                return peopleRatings.get(person).get(film);
            }
        }
        return Rating.NOT_WATCHED;
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        return peopleRatings.getOrDefault(person, new HashMap<Film, Rating>());
    }

    public List<Person> reviewers() {
        return new ArrayList<Person>(peopleRatings.keySet());
    }
}
