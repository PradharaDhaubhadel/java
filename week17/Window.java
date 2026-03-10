package week17;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class Window here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
/*public class Window
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("CS4001NI Programming");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
} = one method by creating objects of jframe*/
public class Window extends JFrame
{
    public Window()
    {
        setTitle("CS4001NI Programming");
        setSize(500,500);
        
        JPanel panel = new JPanel();
        panel.setBounds(50,50,400,400);
        //panel.setBackground(Color.BLUE);
        panel.setBorder(BorderFactory.createTitledBorder("User Details"));
        
        JLabel label = new JLabel("Username: ");
        label.setFont(new Font("Arial",Font.BOLD, 15));
        label.setBounds(20,50,100,30);
        
        JTextField txtField = new JTextField();
        txtField.setBounds(130,50,100,30);
        
        JButton btn = new JButton("Submit"); //(y = 50+30 = 80 so y for submit > 80
        btn.setBounds(20, 90, 100, 30);
        btn.setBackground(Color.PINK);
        //btn.setBackground(new Color(255,200,0));
        btn.setForeground(Color.BLUE);
        
        panel.add(btn);
        panel.add(txtField);
        panel.add(label);
        panel.setLayout(null);
        setLayout(null);//null set garepchi set bouds ko value lincha
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
    }
    
    public static void main(String[] args)
    {
        Window wd = new Window();
        wd.setVisible(true);
    }
}