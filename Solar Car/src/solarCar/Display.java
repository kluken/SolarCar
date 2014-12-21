package solarCar;


import javax.swing.*;
import java.awt.Color;




public class Display
{


    JPanel titlePanel;
    JLabel solarStat, motorStat, batteryStat;

    public JPanel createContentPane (){

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);

        // Creation of a Panel to contain the title labels
        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(10, 0);
        titlePanel.setSize(1024, 768);
        totalGUI.add(titlePanel);

        solarStat = new JLabel("<html><span style='font-size:14px'>Solar Statistics</span></html>");
        solarStat.setLocation(0, 0);
        solarStat.setSize(150, 30);
        solarStat.setHorizontalAlignment(0);
        solarStat.setForeground(Color.blue);
        titlePanel.add(solarStat);
        
        motorStat = new JLabel("<html><span style='font-size:14px'> Motor Statistics </span></html>");
        motorStat.setLocation(0, 200);
        motorStat.setSize(150, 30);
        motorStat.setHorizontalAlignment(0);
        motorStat.setForeground(Color.blue);
        titlePanel.add(motorStat);
        
        batteryStat = new JLabel("<html><span style='font-size:14px'>Battery Statistics</span></html>");
        batteryStat.setLocation(0, 400);
        batteryStat.setSize(150, 30);
        batteryStat.setHorizontalAlignment(0);
        batteryStat.setForeground(Color.blue);
        titlePanel.add(batteryStat);
       
        totalGUI.setOpaque(true);
        return totalGUI;
    }


    public static void createAndShowGUI() {

        JFrame frame = new JFrame("UWS Solar Car Project");

        //Create and set up the content pane.
        Display demo = new Display();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }

}