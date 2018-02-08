import org.jfree.ui.RefineryUtilities;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame =new JFrame("Progress Control");
        frame.setContentPane(new MainMenu(frame).panel1);
        frame.setPreferredSize(new java.awt.Dimension( 400 , 400 ));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        RefineryUtilities.centerFrameOnScreen(frame);
        frame.setVisible(true);
    }
}
