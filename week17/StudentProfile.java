package week17;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class StudentProfile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentProfile extends JFrame
{
    public StudentProfile(){
        setTitle("Student Profile");
        setSize(500,500);
        
        JPanel panel = new JPanel();
        panel.setBounds(50,50,400,400);
        panel.setBorder(BorderFactory.createTitledBorder("Student Details"));
        
        JLabel label = new JLabel("Student Name: ");
        label.setFont(new Font("Arial",Font.BOLD, 12));
        label.setBounds(20,50,100,30);
        
        panel.add(label);
        panel.setLayout(null);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            StudentProfile p = new StudentProfile();
            p.setVisible(true);
        }
        );
    }
}