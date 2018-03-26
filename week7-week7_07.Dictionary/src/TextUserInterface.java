import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        System.out.println("Statement:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user interface");
        while (true) {
            System.out.println("Statement: ");
            String command = getUserInput();
            if (command.equals("quit")) {
                System.out.println("Cheers!");
                break;
            }
            handleStatement(command);
        }
    }

    public void handleStatement(String command) {
        if (command.equals("add")) {
            add();
        } else if (command.equals("translate")) {
            translate();
        } else {
            System.out.println("Unknown statement");
        }
    }

    public void add() {
        System.out.println("In Finnish: ");
        String word = getUserInput();

        System.out.println("Translation: ");
        String translation = getUserInput();

        this.dictionary.add(word, translation);
    }

    public void translate() {
        System.out.println("Give a word: ");
        String word = getUserInput();
        System.out.println("Translation: " + this.dictionary.translate(word));
    }

    public String getUserInput() {
        return this.reader.nextLine();
    }
}
