package week17;
import javax.swing.*;

/**
 * Write a description of class MainLauncher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MainLauncher
{
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            Student s1 = new Student("NPCP4a1101","Pradhara Dhaubhadel","Computing");
            Student s2 = new Student("NPNT51b3207","Rita Shrestha","Networking");
            
            IDCardWindow windowOne = new IDCardWindow(s1);
            IDCardWindow windowTwo = new IDCardWindow(s2);
            windowOne.setVisible(true);
            windowTwo.setVisible(true);
            
        }
        );
    }
    
}