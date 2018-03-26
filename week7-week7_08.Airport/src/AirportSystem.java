import java.util.ArrayList;

public class AirportSystem {
    private ArrayList<Plane> planes = new ArrayList<Plane>();

    public void addPlane(String planeId, int capacity) {
        Plane plane = new Plane(planeId, capacity);
        this.planes.add(plane);
    }

    public void addFlight(String planeId, String departureCode, String destinationCode) {
        String flight = departureCode + "-" + destinationCode;
        Plane plane = findPlane(planeId);
        plane.addFlight(flight);
    }

    private Plane findPlane(String planeId) {
        for (Plane plane : this.planes) {
            if (plane.isThePlane(planeId)) {
                return plane;
            }
        }
        return null;
    }

    public void printPlanes() {
        for (Plane plane : this.planes) {
            System.out.println(plane);
        }
    }

    public void printPlane(String planeId) {
        System.out.println(findPlane(planeId));
    }

    public void printFlights() {
        for (Plane plane: this.planes) {
            plane.printFlights();
        }
    }


}
