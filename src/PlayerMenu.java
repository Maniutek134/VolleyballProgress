import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Karasiówka on 2017-04-25.
 */
public class PlayerMenu {
    private Player player;
    public JPanel panel1;
    private JButton addMatchButton;
    private JButton StatButton;
    private JButton BackButton;
    private JButton InfoButton;
    private JButton InfoUpdateButton;
    private JButton DeleteButton;
    private JFrame frame;


    public PlayerMenu(String fileName,JFrame frame) throws IOException {
//        //System.out.println(fileName);
        this.player = new Player();
        this.frame=frame;
        {
            FileReader fileReader = new FileReader(fileName + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            {
                this.player.setName(bufferedReader.readLine());                                //updating player from file
                this.player.setSurname(bufferedReader.readLine());
                this.player.setAge(Integer.valueOf(bufferedReader.readLine()));
                this.player.setHeight(Integer.valueOf(bufferedReader.readLine()));
                this.player.setWeight(Integer.valueOf(bufferedReader.readLine()));


                String tempSpike = bufferedReader.readLine();
                String tempBlock = bufferedReader.readLine();

                String tempPossition = bufferedReader.readLine();
                String tempCurrentClub = bufferedReader.readLine();

                String tempAttacks = bufferedReader.readLine();
                String tempBlocks = bufferedReader.readLine();
                String tempBadAttacks = bufferedReader.readLine();
                String tempBadServices = bufferedReader.readLine();
                String tempMistakes = bufferedReader.readLine();
                String tempResults = bufferedReader.readLine();

                tempSpike = tempSpike.replaceAll("[<>\\[\\],-]", "");
                tempBlock = tempBlock.replaceAll("[<>\\[\\],-]", "");
                tempAttacks = tempAttacks.replaceAll("[<>\\[\\],-]", "");
                tempBlocks = tempBlocks.replaceAll("[<>\\[\\],-]", "");
                tempBadAttacks = tempBadAttacks.replaceAll("[<>\\[\\],-]", "");
                tempBadServices = tempBadServices.replaceAll("[<>\\[\\],-]", "");
                tempMistakes = tempMistakes.replaceAll("[<>\\[\\],-]", "");
                tempResults = tempResults.replaceAll("[<>\\[\\],-]", "");

                this.player.setSpike(stringToList(tempSpike));
                this.player.setBlock(stringToList(tempBlock));
                this.player.setCurrentClub(tempCurrentClub);
                this.player.setPossition(tempPossition);
                this.player.setAttacks(stringToList(tempAttacks));
                this.player.setBlocks(stringToList(tempBlocks));
                this.player.setBadAttacks(stringToList(tempBadAttacks));
                this.player.setBadServices(stringToList(tempBadServices));
                this.player.setMistakes(stringToList(tempMistakes));
                this.player.setResults(stringToList(tempResults));
            }

            bufferedReader.close();
        }

        addMatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                            //next frame
                frame.setContentPane(new AddMatch(player,frame).panel1);
                frame.setVisible(true);


            }
        });
        StatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Statistics attackChart = new Statistics("Statistics", player);
                attackChart.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                attackChart.pack();
                attackChart.setVisible(true);
                attackChart.setLocationRelativeTo(null);
            }
        });
        BackButton.addActionListener(new ActionListener() {
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
        InfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.setContentPane(new PlayerInfo(player,frame).panel1);
                frame.setVisible(true);


            }
        });
        InfoUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new InfoUpdate(player,frame).panel1);
                frame.setVisible(true);
            }
        });
        DeleteButton.addActionListener(new ActionListener()  {
            @Override
            public void actionPerformed(ActionEvent e) {
                File playerFile=new File(player.getName()+player.getSurname()+".txt");
                Path playerPath= Paths.get(player.getName()+player.getSurname()+".txt");
                File playersFile=new File("Players.txt");

                try {
                    Files.delete(playerPath);
                    JOptionPane.showMessageDialog(null,"Player has been deleted");
                    removeline(player.getName()+player.getSurname(),playersFile);
                    frame.setContentPane(new FindPlayer(frame).panel1);
                    frame.setVisible(true);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null,"Can't delete player");
                }

            }
        });
    }

    public List<Integer> stringToList(String string){             //it returns list whitch is ready to add to player's attribute
        List<Integer> list = new ArrayList<Integer>();
        Scanner scanner = new Scanner(string);
        while(scanner.hasNextInt()){
            list.add(scanner.nextInt());
        }
        return list;
    }

    public void removeline(String string, File inputFile) throws IOException {
        File tempFile = new File("test1.txt");
        //File temp2File =new File("test2.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile, true));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(null!=currentLine && !currentLine.equalsIgnoreCase(string)){
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }
        writer.close();
        reader.close();

        String fileName=inputFile.getName();
        inputFile.delete();
        //inputFile.
        Path source=tempFile.toPath();
        Files.move(source,source.resolveSibling(inputFile.getName()));

    }
}
