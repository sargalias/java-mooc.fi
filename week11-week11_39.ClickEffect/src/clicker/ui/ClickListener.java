package clicker.ui;

import clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickListener implements ActionListener {
    private Calculator calculator;
    private JLabel jLabel;

    public ClickListener(Calculator calculator, JLabel jLabel) {
        this.calculator = calculator;
        this.jLabel = jLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.calculator.increase();
        this.jLabel.setText("" + this.calculator.giveValue());
    }
}
