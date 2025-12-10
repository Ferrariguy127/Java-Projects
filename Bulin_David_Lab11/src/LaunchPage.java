import javax.swing.*;
import java.awt.*;

public class LaunchPage {

    JFrame frame = new JFrame();

    LaunchPage(){
        frame.setTitle("New Page Here!");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLUE);
    }
}
