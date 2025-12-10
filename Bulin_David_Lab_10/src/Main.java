import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JLabel label = new JLabel();//Creates the label
        label.setText("Basic GUI Development");//Populates the label
        label.setFont(new Font("Helvetica",Font.BOLD+Font.ITALIC,30));
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);

        //This sets the button
        JButton button = new JButton();
        button.setBounds(50,95,200,50);
        button.setText("David Bulin");
        button.setVerticalAlignment(JButton.CENTER);
        button.setBackground(new Color(255,150,0));

        JFrame frame = new JFrame();
        frame.setTitle("My First GUI LAB");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setResizable(false);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        panel5.setLayout(null);

        panel1.setBackground(Color.yellow);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.red);
        panel5.setBackground(Color.white);

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.WEST);
        frame.add(panel3,BorderLayout.EAST);
        frame.add(panel4,BorderLayout.SOUTH);
        frame.add(panel5,BorderLayout.CENTER);

        panel1.add(label);
        panel5.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("David Bulin");
            }
        });
        }
    }