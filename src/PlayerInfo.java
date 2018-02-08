import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Karasiówka on 2017-05-09.
 */
public class PlayerInfo {
    public JPanel panel1;
    private JLabel NameLabel;
    private JLabel SurnameLabel;
    private JLabel HeightLabel;
    private JLabel WeightLabel;
    private JLabel AgeLabel;
    private JLabel SpikeLabel;
    private JLabel BlockLabel;
    private JLabel CurrentClubLabel;
    private JLabel PossitionLabel;
    private JLabel Name;
    private JLabel Surname;
    private JLabel Possition;
    private JLabel Height;
    private JLabel Weight;
    private JLabel Age;
    private JLabel Spike;
    private JLabel Block;
    private JLabel CurrentClub;
    private JButton BackButton;
    private Player player;
    private JFrame frame;

    public PlayerInfo(Player player,JFrame frame) {
        this.player = player;
        this.frame=frame;

        this.Name.setText(this.player.getName());
        this.Surname.setText(this.player.getSurname());
        this.Possition.setText(this.player.getPossition());
        this.Height.setText(Integer.toString(this.player.getHeight()));
        this.Weight.setText(Integer.toString(this.player.getWeight()));
        this.Age.setText(Integer.toString(this.player.getAge()));
        this.Spike.setText(Integer.toString(this.player.getSpike().get(this.player.getSpike().size()-1)));                               //last element
        this.Block.setText(Integer.toString(this.player.getBlock().get(this.player.getBlock().size()-1)));
        this.CurrentClub.setText(this.player.getCurrentClub());

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                                                            //previous frame
                try {
                    frame.setContentPane(new PlayerMenu(player.getName() + player.getSurname(), frame).panel1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                frame.setVisible(true);
            }
        });
    }
}
