import com.sun.xml.internal.fastinfoset.util.StringArray;
import javafx.scene.control.ListView;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karasiówka on 2017-04-23.
 * choosing player form list
 */
public class FindPlayer extends JFrame{
    public  JPanel panel1;
    private JFrame frame;
    private DefaultListModel listModel;
    public JList list1 ;
    private JScrollPane scrollPanel;
    private JButton BackButton;
    private ListSelectionListener[] listeners;



    public FindPlayer(JFrame frame) throws IOException {
        this.frame=frame;
        list1.setListData(getPlayers());
        list1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {

                if (!arg0.getValueIsAdjusting()) {
                    try {

                        frame.setContentPane(new PlayerMenu(list1.getSelectedValue().toString(),frame).panel1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    frame.setVisible(true);
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



    public String[] getPlayers() throws IOException {
        FileReader fileReader = new FileReader("Players.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listOfPlayers = new ArrayList<>();

        String textLine = bufferedReader.readLine();

        do {
            listOfPlayers.add(textLine);                           //creating list of players
            textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        String[] Players = new String[listOfPlayers.size()];      //converting listOfPlayers to stringArray

        for(int i=0; i<listOfPlayers.size(); i++){
            Players[i]=listOfPlayers.get(i);
        }

        return Players;
    }
}

