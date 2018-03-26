import java.util.Scanner;

public class AirportPanelUI {
    private Scanner reader;
    private AirportSystem airportSystem;

    public AirportPanelUI(Scanner reader, AirportSystem airportSystem) {
        this.reader = reader;
        this.airportSystem = airportSystem;
    }

    public void start() {
        printIntroduction();
        while (true) {
            printInstructions();
            String command = getUserInputString();
            if (command.equals("x")) {
                break;
            }
            handleCommand(command);
        }

        printIntroduction2();
        while (true) {
            printInstructions2();
            String command = getUserInputString();
            if (command.equals("x")) {
                break;
            }
            handleCommand2(command);
        }
    }

    private void printIntroduction() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
    }

    private void printInstructions() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
        System.out.println("> ");
    }

    private void printIntroduction2() {
        System.out.println("Flight service");
        System.out.println("------------");
    }

    private void printInstructions2() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
        System.out.println("> ");
    }

    private void handleCommand(String command) {
        if (command.equals("1")) {
            addPlane();
        } else if (command.equals("2")) {
            addFlight();
        }
    }

    private void handleCommand2(String command) {
        if (command.equals("1")) {
            airportSystem.printPlanes();
        } else if (command.equals("2")) {
            airportSystem.printFlights();
        } else if (command.equals("3")) {
            System.out.println("Give plane ID: ");
            airportSystem.printPlane(getUserInputString());
        }
    }

    private void addPlane() {
        System.out.println("Give plane ID: ");
        String planeId = getUserInputString();
        System.out.println("Give plane capacity: ");
        int planeCapacity = getUserInputInt();
        this.airportSystem.addPlane(planeId, planeCapacity);
    }

    private void addFlight() {
        System.out.println("Give plane ID: ");
        String planeId = getUserInputString();
        System.out.println("Give departure airport code: ");
        String departureCode = getUserInputString();
        System.out.println("Give destination airport code: ");
        String destinationCode = getUserInputString();
        this.airportSystem.addFlight(planeId, departureCode, destinationCode);
    }

    private String getUserInputString() {
        return this.reader.nextLine();
    }

    private int getUserInputInt() {
        return Integer.parseInt(getUserInputString());
    }
}
