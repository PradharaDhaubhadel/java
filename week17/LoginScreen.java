package week17;
import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class LoginScreen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LoginScreen extends JFrame
{
    public LoginScreen(){
        setTitle("Login");
        setSize(500,500);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.MAGENTA);
        panel.setBounds(20,20,400,400);
        
        JLabel label = new JLabel("Username: ");
        label.setFont(new Font("Arial",Font.BOLD, 15));
        label.setBounds(20,50,100,30);
        
        JTextField txtField = new JTextField();
        txtField.setBounds(130,50,100,30);
        
        JLabel label1 = new JLabel("Password: ");
        label1.setFont(new Font("Arial",Font.BOLD, 15));
        label1.setBounds(20,100,100,30);
        
        JTextField txtField1 = new JTextField();
        txtField1.setBounds(130,100,100,30);
        
        JButton button = new JButton("Submit"); 
        button.setBounds(20, 260, 100, 30);
        
        add(panel);
        panel.add(label);
        panel.add(txtField);
        panel.add(label1);
        panel.add(txtField1);
        panel.add(button);

    
        panel.setLayout(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            LoginScreen ls = new LoginScreen();
            ls.setVisible(true);
        }
        );
    }
    
}