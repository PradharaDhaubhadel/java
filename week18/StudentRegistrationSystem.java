package week18;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Write a description of class StudentRegistrationSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentRegistrationSystem extends JFrame
{
    public StudentRegistrationSystem(){
        
        setTitle("Student Registration System");
        setSize(700,600);
        
        JPanel panel = new JPanel();
        panel.setBounds(5,5,650,500);
        panel.setLayout(null);
        
        JLabel name = new JLabel("Student Name: ");
        name.setBounds(10,10,120,30);
        
        JTextField nametxtField = new JTextField();
        nametxtField.setBounds(140,10,200,30);
        
        JLabel age = new JLabel("Age: ");
        age.setBounds(10,60,120,30);
        
        JTextField agetxtField = new JTextField();
        agetxtField.setBounds(140,60,100,30);
        
        JLabel phoneNumber = new JLabel("Phone Number: ");
        phoneNumber.setBounds(10,110,120,30);
        
        JTextField phonetxtField = new JTextField();
        phonetxtField.setBounds(140,110,200,30);
        
        JLabel department = new JLabel("Departments: ");
        department.setBounds(10,160,120,30);
        
        String[] departmentNames = {"Computing", "Networking","Multimedia","AI", "Computer Science", "Accounting", "Business", "Math","Physics","Chemistry","Language","CSIT"};
        JComboBox<String> departmentBox = new JComboBox<>(departmentNames);
        departmentBox.setBounds(140,160,200,30);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(10,210,100,30);
        
        JRadioButton male = new JRadioButton("Male");
        male.setBounds(130,210,60,30);
        
        JRadioButton female = new JRadioButton("Female");
        female.setBounds(200,210,80,30);
        
        JRadioButton other = new JRadioButton("Others");
        other.setBounds(290,210,80,30);
        
        JLabel hobbies = new JLabel("Hobbies: ");
        hobbies.setBounds(10,250,100,30);
        
        JCheckBox read = new JCheckBox("Reading");
        read.setBounds(130,250,90,30);
        
        JCheckBox draw = new JCheckBox("Drawing");
        draw.setBounds(230,250,90,30);
        
        JCheckBox music = new JCheckBox("Music");
        music.setBounds(330,250,70,30);
        
        JCheckBox sport = new JCheckBox("Gaming");
        sport.setBounds(410,250,90,30);
        
        JCheckBox travel = new JCheckBox("Travelling");
        travel.setBounds(510,250,100,30);

        JButton button = new JButton("Submit"); 
        button.setBounds(10, 380, 100, 30);
        
        JButton btn = new JButton("Save");
        btn.setBounds(10, 430, 100, 30);

        btn.setMnemonic(KeyEvent.VK_S);
        btn.setToolTipText("Save info");
        
        
        
        button.addActionListener(e -> {
            if(nametxtField.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(this,"Please enter name");
                return;
            }
            try{
                int ageNum = Integer.parseInt(agetxtField.getText());
                if(ageNum<0 || ageNum>120){
                    throw new IllegalArgumentException("Invalid age");
                }
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"Please enter a valid number for age");
                return;
            }
            if(!phonetxtField.getText().trim().matches("9[78]\\d{8}")){
                JOptionPane.showMessageDialog(this,"Please enter valid phone number");
            }
        });
        
        /*button.setEnabled(false);
        if(!nametxtField.getText().trim().isEmpty() && !agetxtField.getText().trim().isEmpty() && !phonetxtField.getText().isEmpty()){
            button.setEnabled(true);
        }*/ 
        
        String[] columns ={"Student Name","Age","Phone Number","Department"};
        JTable table = new JTable(new Object[][]{}, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,300,500,50);
        
        button.addActionListener(e -> {
            Object[][] data = {{nametxtField.getText(), agetxtField.getText(),phonetxtField.getText(),departmentBox.getSelectedItem()}};
        JTable newTable = new JTable(data,columns);
        scrollPane.setViewportView(newTable);
        });
        
        

        add(panel);
        panel.add(name);
        panel.add(nametxtField);
        panel.add(age);
        panel.add(agetxtField);
        panel.add(phoneNumber);
        panel.add(phonetxtField);
        panel.add(department);
        panel.add(departmentBox);
        panel.add(gender);
        panel.add(male);
        panel.add(female);
        panel.add(other);
        panel.add(hobbies);
        panel.add(read);
        panel.add(draw);
        panel.add(music);
        panel.add(sport);
        panel.add(travel);
        panel.add(button);
        panel.add(btn);
        panel.add(scrollPane);

    
        panel.setLayout(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null);
    }
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(()->
        {
            StudentRegistrationSystem s = new StudentRegistrationSystem();
            s.setVisible(true);
        }
        );
    }
    
}