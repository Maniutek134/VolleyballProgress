import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Karasiówka on 2017-04-30.
 */
public class AddMatch {
    public JPanel panel1;
    private JLabel attacksLabel;
    private JLabel blocksLabel;
    private JLabel badAttacksLabel;
    private JLabel badServicesLabel;
    private JLabel mistakesLabel;
    private JTextField attacksField;
    private JTextField blocksField;
    private JTextField badAttacksField;
    private JTextField badServicesField;
    private JLabel resultLabel;
    private JTextField mistakesField;
    private JTextField resultField;
    private JButton addButton;
    private JButton BackButton;
    private Player player;
    private JFrame frame;


    public AddMatch(Player player, JFrame frame) {
        //Player player1=new Player();
        this.frame=frame;
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                                                                 //adding data to selected player

                try {

                    if (Integer.valueOf(resultField.getText())!=1 && Integer.valueOf(resultField.getText())!=0){
                        throw new IllegalArgumentException("unexpected value")  ;                                           //checking proper value of result field
                    }

                    player.addAttacks(Integer.valueOf(attacksField.getText()));
                    player.addBlocks(Integer.valueOf(blocksField.getText()));
                    player.addBadAttacks(Integer.valueOf(badAttacksField.getText()));
                    player.addBadServices(Integer.valueOf(badServicesField.getText()));
                    player.addMistakes(Integer.valueOf(mistakesField.getText()));
                    player.addResults(Integer.valueOf(resultField.getText()));

                    try {                                                                                                   //writing to file
                        writeTofilePlayer(player);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Updating complited");

                    //frame.dispose();
                    //JFrame frameNew = new JFrame("Player Menu" + " " + player.getName() + player.getSurname());                 //previous frame
                    try {
                        frame.setContentPane(new PlayerMenu(player.getName() + player.getSurname(), frame).panel1);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    frame.setVisible(true);

                }
                catch(NumberFormatException e2){
                    JOptionPane.showMessageDialog(null,"Can't add new match, try again with proper values");
                }
                catch (IllegalArgumentException e3){
                    JOptionPane.showMessageDialog(null,"Wrong value in RESULT field, try again");
                }

            }
        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //frame.dispose();
                //JFrame frameNew = new JFrame("Player Menu" + " " + player.getName() + player.getSurname());                 //previous frame
                try {
                    frame.setContentPane(new PlayerMenu(player.getName() + player.getSurname(), frame).panel1);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                frame.setVisible(true);

            }
        });
    }

    public void writeTofilePlayer(Player player) throws IOException {
        PrintWriter write = new PrintWriter(player.getName()+player.getSurname()+".txt");
        write.println(player.getName()+"\r\n"+player.getSurname()+"\r\n"+player.getAge()+"\r\n"+player.getHeight()+"\r\n"+player.getWeight()+"\r\n"+player.getSpike()+"\r\n"+player.getBlock()+"\r\n"+player.getPossition()+"\r\n"+player.getCurrentClub()+"\r\n"+player.getAttacks()+"\r\n"+player.getBlocks()+"\r\n"+player.getBadAttacks()+"\r\n"+player.getBadServices()+"\r\n"+player.getMistakes()+"\r\n"+player.getResults());
        write.close();

    }

}


