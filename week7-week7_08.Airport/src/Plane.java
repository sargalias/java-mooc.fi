import java.util.ArrayList;

public class Plane {
    private String planeId;
    private int capacity;
    private ArrayList<String> flights = new ArrayList<String>();

    public Plane(String planeId, int capacity) {
        this.planeId = planeId;
        this.capacity = capacity;
    }

    public void addFlight(String flightId) {
        this.flights.add(flightId);
    }

    public boolean isThePlane(String name) {
        return this.planeId.equals(name);
    }

    @Override
    public String toString() {
        return this.planeId + " (" + this.capacity + " ppl)";
    }

    public void printFlights() {
        String prefix = this.toString();
        for (String flight : flights) {
            String suffix = " (" + flight + ")";
            System.out.println(prefix + suffix);
        }
    }
}
