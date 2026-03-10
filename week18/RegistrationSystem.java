package week18;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;


/**
 * Write a description of class RegistrationSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RegistrationSystem extends JFrame
{
    public RegistrationSystem(){
        setTitle("Student Registration System");
        setSize(700,600);
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,650,500);
        
        JLabel id = new JLabel("Student ID: ");
        id.setBounds(10,10,120,30);
        
        JTextField idtxtField = new JTextField();
        idtxtField.setBounds(140,10,200,30);
        
        JLabel name = new JLabel("Student Name:");
        name.setBounds(10, 60, 120, 30);
        
        JTextField nametxtField = new JTextField();
        nametxtField.setBounds(140, 60, 200, 30);

        
        JLabel course = new JLabel("Course:");
        course.setBounds(10, 110, 120, 30);
        
        String[] courseNames = {"AI", "BBA", "BSc", "BIT"};
        JComboBox<String> courseBox = new JComboBox<>(courseNames);
        courseBox.setBounds(140, 110, 200, 30);

        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(10, 160, 120, 30);
        
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(140, 160, 80, 30);
        
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 160, 80, 30);
        
        JRadioButton other = new JRadioButton("Others");
        other.setBounds(300, 160, 80, 30);

        JLabel skill = new JLabel("Skill:");
        skill.setBounds(10, 210, 120, 30);
        
        JTextField skilltxtField = new JTextField();
        skilltxtField.setBounds(140, 210, 200, 30);

        JButton submitBtn = new JButton("Submit");
        submitBtn.setBounds(50, 270, 100, 40);

        JButton resetBtn = new JButton("Reset");
        resetBtn.setBounds(160, 270, 100, 40);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(270, 270, 100, 40);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(380, 270, 100, 40);


        add(panel);
        panel.add(id);
        panel.add(idtxtField);
        panel.add(name);
        panel.add(nametxtField);
        panel.add(course);
        panel.add(courseBox);
        panel.add(gender);
        panel.add(male);
        panel.add(female);
        panel.add(other);
        panel.add(skill);
        panel.add(skilltxtField);
        panel.add(submitBtn);
        panel.add(resetBtn);
        panel.add(searchBtn);
        panel.add(deleteBtn);


    
        panel.setLayout(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            RegistrationSystem s1 = new RegistrationSystem();
            s1.setVisible(true);
        }
        );
    }
        
        
    }
    
