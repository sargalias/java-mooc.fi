import java.util.HashMap;
import java.util.HashSet;

public class VehicleRegister {
    private HashMap<RegistrationPlate, String> register
            = new HashMap<RegistrationPlate, String>();

    public boolean add(RegistrationPlate plate, String owner) {
        if (register.containsKey(plate)) {
            return false;
        }
        this.register.put(plate, owner);
        return true;
    }

    public String get(RegistrationPlate plate) {
        if (register.containsKey(plate)) {
            return this.register.get(plate);
        }
        return null;
    }

    public boolean delete(RegistrationPlate plate) {
        if (!register.containsKey(plate)) {
            return false;
        }
        this.register.remove(plate);
        return true;
    }

    public void printRegistrationPlates() {
        for (RegistrationPlate key : this.register.keySet()) {
            System.out.println(key);
        }
    }

    public void printOwners() {
        HashSet<String> owners = new HashSet<String>(this.register.values());
        for (String owner : owners) {
            System.out.println(owner);
        }

    }
}
