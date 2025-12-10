//David Bulin
//Lab 11
//November 17th 2023

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class LaunchTextPage {

    JFrame frame = new JFrame();

    JButton button = new JButton();
    JTextField textField = new JTextField();



    LaunchTextPage(){
        frame.setTitle("Help Page Requests");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.gray);

        textField.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        frame.add(textField);

        frame.add(button);
        frame.setResizable(false);

        textField.setPreferredSize(new Dimension(500,100));
        textField.setText("");

        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setLayout(new FlowLayout(FlowLayout.CENTER, 5,5));

        button.setText("Submit");
        button.setVisible(true);
        button.setVerticalAlignment(textField.CENTER);
        button.setHorizontalAlignment(textField.CENTER);
        button.setBackground(Color.BLUE);
        button.setLayout(new FlowLayout(FlowLayout.CENTER));
        button.setForeground(Color.WHITE);
        textField.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(textField.getText());
                button.setEnabled(false);//This makes it so the button can only be used once.
            }
        });
    }
}
