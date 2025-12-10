import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchButtonPage {

    JFrame frame = new JFrame();
    JButton button = new JButton();


    LaunchButtonPage(){
        frame.setTitle("Deletion Page");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.GREEN);
        frame.add(button);
        frame.setResizable(false);

        button.setText("Delete");
        button.setVisible(true);
        button.setVerticalAlignment(JButton.CENTER);
        button.setHorizontalAlignment(JButton.CENTER);
        button.setBackground(Color.BLUE);
        button.setBounds(200, 175, 100, 100);
        button.setForeground(Color.WHITE);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("The Selected text has been deleted.");
            }
        });
    }
}
