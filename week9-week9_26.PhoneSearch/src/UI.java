import java.util.List;
import java.util.Scanner;

public class UI {
    private Directory directory = new Directory();
    private Scanner reader;

    public UI(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        instructions();
        while (true) {
            System.out.println("command: ");
            String command = reader.nextLine();
            if (command.equals("x")) {
                return;
            } else if (command.equals("1")) {
                addNumber();
            } else if (command.equals("2")) {
                searchNumber();
            } else if (command.equals("3")) {
                searchByNumber();
            } else if (command.equals("4")) {
                addAddress();
            } else if (command.equals("5")) {
                findPersonalInformation();
            } else if (command.equals("6")) {
                clearInformation();
            } else if (command.equals("7")) {
                searchByKeyword();
            }
        }
    }

    public void instructions() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit"
        );
    }

    public void addNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        System.out.println("number: ");
        String number = reader.nextLine();
        this.directory.addNumber(name, number);
    }

    public void searchNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        Person person = this.directory.getPerson(name);
        displayNumbers1(person);
    }

    public void displayNumbers1(Person person) {
        if (person == null) {
            System.out.println("  not found");
            return;
        }
        List<String> numbers = person.getNumbers();
        for (String num : numbers) {
            System.out.println(" " + num);
        }
    }

    public void searchByNumber() {
        System.out.println("number: ");
        String number = reader.nextLine();
        Person person = this.directory.searchByNumber(number);
        if (person == null) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + person.getName());
        }
    }

    public void addAddress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        this.directory.addAddress(name, street, city);
    }

    public void findPersonalInformation() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        Person person = directory.getPerson(name);
        if (person == null) {
            System.out.println("  not found");
        } else {
            displayAddress(person);
            displayNumbers2(person);
        }
    }

    public void displayAddress(Person person) {
        String address = person.getAddress();
        if (address == null) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + address);
        }
    }

    public void displayNumbers2(Person person) {
        List<String> numbers = person.getNumbers();
        if (numbers.isEmpty()) {
            System.out.println("  phone number not found");
            return;
        }
        System.out.println("  phone numbers:");
        for (String num : numbers) {
            System.out.println("   " + num);
        }
    }

    public void clearInformation() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        this.directory.clearInformation(name);
    }

    public void searchByKeyword() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<Person> people = directory.searchAll(keyword);
        if (people.isEmpty()) {
            System.out.println(" keyword not found");
        } else {
            for (Person person : people) {
                System.out.println(" " + person.getName());
                displayAddress(person);
                displayNumbers2(person);
            }
        }
    }

}
