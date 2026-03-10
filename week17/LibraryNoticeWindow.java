package week17;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class LibraryNoticeWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryNoticeWindow extends JFrame
{
    public LibraryNoticeWindow(){
        setTitle("Library Notice");
        setSize(400,300);
        
        JPanel panel = new JPanel();
        panel.setBounds(50,50,400,400);
        
        JLabel label = new JLabel("The Library opens at 7:00 AM ");
        label.setFont(new Font("Arial",Font.BOLD, 12));
        label.setBounds(20,50,200,30);
        
        panel.add(label);
        panel.setLayout(null);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
        setLayout(null);
        add(panel);
    }
    
    public static void main(String[] args)
    {
        LibraryNoticeWindow w1 = new LibraryNoticeWindow();
        w1.setVisible(true);
        
    }
}