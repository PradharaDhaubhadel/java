package week17;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class IDCardPreview here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class IDCardPreview extends JFrame
{
    public IDCardPreview(){
        setTitle("Student ID Card Preview");
        setSize(500,500);
        
        JPanel panel = new JPanel();
        panel.setBounds(50,50,400,400);
        
        String text = "<html><body> <div style='text-align: left'> <p> Name: Pradhara Dhaubhadel </p><p>Module: Programming </p><p>College: Islington College</p></div></body></html>";
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        //label.setVerticalAlignment(SwingCinstants.CENTER);
        //label.setHorizontalAlignment(SwingCinstants.CENTER);
        label.setBounds(20,20,300,300);
        
        panel.add(label);
        panel.setLayout(null);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(null);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            IDCardPreview c = new IDCardPreview();
            c.setVisible(true);
        }
        );
    }
}