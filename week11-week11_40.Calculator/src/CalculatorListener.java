import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorListener implements ActionListener {
    private Calculator calculator;
    private JTextField currentVal;
    private JTextField val;
    private JButton plusButton;
    private JButton minusButton;
    private JButton resetButton;

    public CalculatorListener(Calculator calculator, JTextField currentVal, JTextField val, JButton plusButton, JButton minusButton, JButton resetButton) {
        this.calculator = calculator;
        this.currentVal = currentVal;
        this.val = val;
        this.plusButton = plusButton;
        this.minusButton = minusButton;
        this.resetButton = resetButton;
    }

    private void reset() {
        if (currentVal.getText().equals("0")) {
            this.resetButton.setEnabled(false);
        } else {
            this.resetButton.setEnabled(true);
        }
    }

    private void wipeInput() {
        this.val.setText("");
    }

    public void actionPerformed(ActionEvent e) {
        int val;
        try {
            val = Integer.parseInt(this.val.getText());
        } catch (NumberFormatException exc) {
            wipeInput();
            return;
        }

        if (e.getActionCommand().equals("+")) {
            calculator.plus(val);
        } else if (e.getActionCommand().equals("-")) {
            calculator.minus(val);
        } else {
            calculator.reset();
        }
        currentVal.setText("" + calculator.getVal());
        wipeInput();
        reset();
    }
}
