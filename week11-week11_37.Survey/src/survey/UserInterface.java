package survey;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(boxLayout);
        JLabel text1 = new JLabel("Are you?");
        JCheckBox c1 = new JCheckBox("Yes!");
        JCheckBox c2 = new JCheckBox("No!");
        JLabel text2 = new JLabel("Why?");
        JRadioButton r1 = new JRadioButton("No reason.");
        JRadioButton r2 = new JRadioButton("Because it is fun!");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        container.add(text1);
        container.add(c1);
        container.add(c2);
        container.add(text2);
        container.add(r1);
        container.add(r2);
        container.add(new JButton("Done!"));
    }


    public JFrame getFrame() {
        return frame;
    }
}
