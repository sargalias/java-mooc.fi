package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    public int getAverageRatings(Film film) {
        List<Rating> ratings = this.ratings.get(film);
        if (ratings == null) {
            return 0;
        }
        double avg = 0;
        for (Rating rating: ratings) {
            avg += rating.getValue();
        }
        return (int) avg / ratings.size();
    }

    public int compare(Film f1, Film f2) {
        return getAverageRatings(f2) - getAverageRatings(f1);
    }
}
