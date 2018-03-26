import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        Scanner reader = new Scanner(System.in);
        String commands = "1\n" +
                "pekka\n" +
                "12345\n" +
                "2\n" +
                "jukka\n" +
                "2\n" +
                "pekka\n" +
                "1\n" +
                "pekka\n" +
                "11111\n" +
                "2\n" +
                "pekka\n" +
//                "3\n" +
//                "98234\n" +
//                "3\n" +
//                "12345\n" +
//                "5\n" +
//                "pekka\n" +
//                "4\n" +
//                "pekka\n" +
//                "ida ekmantintie\n" +
//                "helsinki\n" +
//                "5\n" +
//                "pekka\n" +
                "x\n";
//        reader = new Scanner(commands);
        UI ui = new UI(reader);
        ui.start();
    }
}
