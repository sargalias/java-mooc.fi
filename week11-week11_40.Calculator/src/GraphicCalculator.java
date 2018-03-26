
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    @Override
    public void run() {
        calculator = new Calculator(0);
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        JTextField output = new JTextField("0");
        output.setEnabled(false);
        JTextField input = new JTextField("0");
        container.add(output);
        container.add(input);

        JPanel bottom = new JPanel(new GridLayout(1, 3));
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton reset = new JButton("Z");

        CalculatorListener calculatorListener = new CalculatorListener(calculator, output, input, plus, minus, reset);

        plus.addActionListener(calculatorListener);
        minus.addActionListener(calculatorListener);
        reset.addActionListener(calculatorListener);
        reset.setEnabled(false);

        // Event listener

        bottom.add(plus);
        bottom.add(minus);
        bottom.add(reset);
        container.add(bottom);

    }

    public JFrame getFrame() {
        return frame;
    }
}
