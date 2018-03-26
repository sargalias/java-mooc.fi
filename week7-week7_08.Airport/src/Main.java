import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        AirportSystem airportSystem = new AirportSystem();
        AirportPanelUI airportPanelUI = new AirportPanelUI(reader, airportSystem);
        airportPanelUI.start();
    }
}
