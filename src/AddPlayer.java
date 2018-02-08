import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static sun.misc.Version.println;

/**
 * Created by Karasiówka on 2017-04-23.
 */
public class AddPlayer {

    private JTextField name;
    private JTextField surname;
    private JTextField age;
    private JTextField height;
    private JTextField weight;
    private JTextField spike;
    private JTextField block;
    private JTextField possition;
    private JTextField currentClub;
    private JButton Addbutton;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;
    private JLabel heightLabel;
    private JLabel weightLabel;
    private JLabel spikeLabel;
    private JLabel blockLabel;
    private JLabel possitionLabel;
    private JLabel clubLabel;
    private JButton BackButton;
    private JFrame frame;
    public JPanel panel1;

    public AddPlayer(JFrame frame) {
            this.frame=frame;
            Addbutton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        Player player1 = new Player(name.getText(), surname.getText(), Integer.valueOf(height.getText()), Integer.valueOf(age.getText()), Integer.valueOf(weight.getText()), Integer.valueOf(spike.getText()), Integer.valueOf(block.getText()), possition.getText(), currentClub.getText());

                        try {
                            writeTofilePlayer(player1);                  //writing new player to new file

                            name.setText("");                              //making fields empty
                            surname.setText("");
                            age.setText("");
                            height.setText("");
                            weight.setText("");
                            spike.setText("");
                            block.setText("");
                            possition.setText("");
                            currentClub.setText("");

                            JOptionPane.showMessageDialog(null,"Success!");

                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                    catch(NumberFormatException e2){
                        JOptionPane.showMessageDialog(null,"Can't add new player, try again with proper values");
                    }
                }
            });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new MainMenu(frame).panel1);
                frame.setVisible(true);
            }
        });
    }


    public void writeTofilePlayer(Player player) throws IOException {
        PrintWriter write = new PrintWriter(player.getName()+player.getSurname()+".txt");
        write.println(player.getName()+"\r\n"+player.getSurname()+"\r\n"+player.getAge()+"\r\n"+player.getHeight()+"\r\n"+player.getWeight()+"\r\n"+player.getSpike()+"\r\n"+player.getBlock()+"\r\n"+player.getPossition()+"\r\n"+player.getCurrentClub()+"\r\n"+player.getAttacks()+"\r\n"+player.getBlocks()+"\r\n"+player.getBadAttacks()+"\r\n"+player.getBadServices()+"\r\n"+player.getMistakes()+"\r\n"+player.getResults());
        write.close();

        BufferedWriter write1 = new BufferedWriter(new FileWriter("Players.txt",true));        //write to general file
        write1.append(player.getName()+player.getSurname()+"\r\n");

        write1.close();


    }
}
