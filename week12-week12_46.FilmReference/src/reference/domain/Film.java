package reference.domain;

public class Film {
    private String name;

    public Film(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object.getClass() != this.getClass()) {
            return false;
        }
        Film other = (Film) object;
        return other.getName().equals(this.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
