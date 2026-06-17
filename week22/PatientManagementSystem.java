package week22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PatientManagementSystem extends JFrame implements ActionListener {

    // GUI Components
    private JTextField txtName, txtAge;
    private JComboBox<String> comboGender, comboDisease;
    private JButton btnSubmit, btnClear;
    private JPanel formPanel;
    private JTextArea displayArea;

    // List to store patient records
    private ArrayList<Patient> patients = new ArrayList<>();

    public PatientManagementSystem() {
        setTitle("Patient Management System");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Form Panel
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Name
        formPanel.add(new JLabel("Patient Name:"));
        txtName = new JTextField();
        formPanel.add(txtName);

        // Age
        formPanel.add(new JLabel("Age:"));
        txtAge = new JTextField();
        formPanel.add(txtAge);

        // Gender
        formPanel.add(new JLabel("Gender:"));
        String[] genders = {"Select Gender", "Male", "Female", "Other"};
        comboGender = new JComboBox<>(genders);
        formPanel.add(comboGender);

        // Disease
        formPanel.add(new JLabel("Disease:"));
        String[] diseases = {"Select Disease", "Flu", "Covid", "Diabetes", "Cancer"};
        comboDisease = new JComboBox<>(diseases);
        formPanel.add(comboDisease);

        // Buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(this);
        btnClear = new JButton("Clear");
        btnClear.addActionListener(e -> clearForm());
        formPanel.add(btnSubmit);
        formPanel.add(btnClear);

        add(formPanel, BorderLayout.NORTH);

        // Display Panel
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(displayArea);
        scroll.setBorder(BorderFactory.createTitledBorder("Patient Records"));
        add(scroll, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> { new PatientManagementSystem();});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) 
        {
             try
             {
                 handleSubmit(); 
                } 
            catch(InvalidPatientDataException ec){
                JOptionPane.showMessageDialog(this, ec.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE); 
            }
            catch(NullPointerException eb)
            {
                JOptionPane.showMessageDialog(this, eb.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);    
            }
                
            catch(NumberFormatException ea)
            {
                JOptionPane.showMessageDialog(this, ea.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            } //mumber format is child class of illegal argument
            catch(IllegalArgumentException ee)
            {
                JOptionPane.showMessageDialog(this, ee.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
            }//child always at top
            
            catch(Exception ez)
                { 
                    JOptionPane.showMessageDialog(this, ez.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                }//parent class always at bottom
        }
    }

    public void handleSubmit() 
    {
        String name = txtName.getText().trim();
        if(name.isEmpty())
        {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        
        String ageText = txtAge.getText().trim();
        /*
        if(ageText.isEmpty())
        {
            throw new IllegalArgumentException("Age cannot be empty.");
        }
        */
        String gender = comboGender.getSelectedItem().toString();
        String disease = comboDisease.getSelectedItem().toString();

        try{
            int age= Integer.parseInt(ageText);
            
            if(age < 0)
            {
                throw new InvalidPatientDataException("Age cannot be less than or equal to 0");
            }
            Patient patient = new Patient(name, age, gender, disease);
            
            if(patient == null)
            {
                throw new NullPointerException("Object cannot be empty");
            }
            else{
                patients.add(patient);
            }
            
            displayArea.append(patient.toString() + "\n");
            
            JOptionPane.showMessageDialog(this, "Patient added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        }
        catch(NumberFormatException ee)
        {
            throw new NumberFormatException("Age cannot be alphabets");
            
        }
        

    }

    public void clearForm() {
        txtName.setText("");
        txtAge.setText("");
        comboGender.setSelectedIndex(0);
        comboDisease.setSelectedIndex(0);
    }

}