
public class RegistrationPlate {
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        } else if (object.getClass() != this.getClass()) {
            return false;
        }
        RegistrationPlate compared = (RegistrationPlate) object;
        if (!this.regCode.equals(compared.regCode)) {
            return false;
        }
        if (!this.country.equals(compared.country)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (this.country + this.regCode).hashCode();
    }

}
