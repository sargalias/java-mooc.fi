package movingfigure;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // test your program here
        UserInterface ui = new UserInterface(new Circle(50, 50, 250));
        SwingUtilities.invokeLater(ui);
        ui = new UserInterface(new Square(50, 50, 250));
        SwingUtilities.invokeLater(ui);
    }
}
