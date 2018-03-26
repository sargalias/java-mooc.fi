package noticeboard;

import java.awt.*;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        container.setLayout(new GridLayout(3, 1));
        JTextField t1 = new JTextField();
        JLabel t2 = new JLabel();
        JButton button = new JButton("Copy!");

        ActionEventListener el = new ActionEventListener(t1, t2);
        button.addActionListener(el);

        container.add(t1);
        container.add(button);
        container.add(t2);
    }
}
