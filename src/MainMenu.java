import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Karasiówka on 2017-04-23.
 */
public class MainMenu {
    private JButton FindPlayer;
    private JButton AddPlayer;
    private JFrame frame;
    public JPanel panel1;
   // public JFrame frame;

    public MainMenu(JFrame frame) {
        this.frame=frame;
        AddPlayer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setContentPane(new AddPlayer(frame).panel1);
                frame.setVisible(true);


            }
        });
        FindPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    frame.setContentPane(new FindPlayer(frame).panel1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(true);

            }
        });
    }

    public void writeTofile(Player player) throws FileNotFoundException {
        PrintWriter write = new PrintWriter("Players.txt");//PrintWriter("Players.txt");
        //write.println(player.getName()+player.getSurname()+player.getAge());
        write.close();
    }
}
