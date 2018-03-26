import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        // Need a user interface to handle all the program input and command calling.
        Scanner reader = new Scanner(System.in);
        String commands = "Bob\n" +
                "Ser\n" +
                "\n" +
                "jump\n" +
                "jump\n" +
                "jump\n" +
                "\n";
        reader = new Scanner(commands);
        UserInterface ui = new UserInterface(reader);
        ui.start();
    }
}
