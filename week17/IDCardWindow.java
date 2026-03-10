package week17;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class IDCardWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IDCardWindow extends JFrame
{
    public IDCardWindow(Student std){
        setTitle("Student ID Card");
        setSize(450,300);
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,250,250);
        
        JLabel label = new JLabel(std.display(), SwingConstants.CENTER);
        label.setBounds(10,10,150,150);
        
        panel.add(label);
        panel.setLayout(null);
        add(panel);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
        
    }
    
}