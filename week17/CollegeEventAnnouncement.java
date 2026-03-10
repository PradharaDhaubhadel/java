package week17;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class CollegeEventAnnouncement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CollegeEventAnnouncement extends JFrame
{
    public CollegeEventAnnouncement(){
        setTitle("Event Announcement Notice");
        setSize(500,500);
        
        JPanel panel = new JPanel();
        panel.setBounds(50,50,400,400);
        panel.setBackground(new Color(173, 216, 230));
        
        JLabel label = new JLabel("Welcome to Orientation Day ");
        label.setFont(new Font("Arial",Font.BOLD, 20));
        label.setBounds(30,50,500,200);
        
        panel.add(label);
        panel.setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        add(panel);
        
        setLocationRelativeTo(null);
        setResizable(false);
        
        
    }
    
    public static void main(String[] args)
    {
        CollegeEventAnnouncement a = new CollegeEventAnnouncement();
        a.setVisible(true);
    }
}