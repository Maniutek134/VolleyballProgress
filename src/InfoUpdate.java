import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Karasiówka on 2017-05-14.
 * class responsible for showing information about player
 */
public class InfoUpdate {
    public JPanel panel1;
    private JTextField AgeTextField;
    private JTextField SpikeTextField;
    private JButton UpdateButton;
    private JButton BackButton;
    private JTextField BlockTextField;
    private JTextField PossitionTextField;
    private JTextField CurrentClubTextField;
    private JLabel AgeLabel;
    private JLabel SpikeLabel;
    private JLabel BlockLabel;
    private JLabel PossitionLabel;
    private JLabel CurrentClubLabel;
    private Player player;
    private JFrame frame;

    public InfoUpdate(Player player, JFrame frame){
        this.player=player;
        this.frame=frame;

        UpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (!AgeTextField.getText().isEmpty()) {
                        player.setAge(Integer.valueOf(AgeTextField.getText()));   //checking if there is something to update
                    }

                    if (!SpikeTextField.getText().isEmpty()) {
                        player.addSpike(Integer.valueOf(SpikeTextField.getText()));
                    }

                    if (!BlockTextField.getText().isEmpty()) {
                        player.addBlock(Integer.valueOf(BlockTextField.getText()));
                    }

                    if (!PossitionTextField.getText().isEmpty()) {
                        player.setPossition(PossitionTextField.getText());
                    }

                    if (!CurrentClubTextField.getText().isEmpty()) {
                        player.setCurrentClub(CurrentClubTextField.getText());
                    }

                    try {
                        writeTofilePlayer(player);                                               //updating the file
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "Updating complited");

                    try {
                        frame.setContentPane(new PlayerMenu(player.getName() + player.getSurname(), frame).panel1);       //back to Player Manu
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    frame.setVisible(true);
                }

                catch(NumberFormatException e2){
                    JOptionPane.showMessageDialog(null,"Can't update, try again with proper values");
                }


            }
        });
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    frame.setContentPane(new PlayerMenu(player.getName() + player.getSurname(), frame).panel1);       //back to Player Manu
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
