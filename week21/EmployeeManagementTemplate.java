package week21;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.*;

public class EmployeeManagementTemplate extends JFrame implements ActionListener
{

    // UI Components
    private JLabel headerLabel;
    private JTextField empIdField, nameField, salaryField;
    private JRadioButton fullTime, partTime, contract;
    private JCheckBox healthInsurance, dentalInsurance, retirementPlan;
    private JComboBox<String> departmentBox;
    private JTextArea displayArea;
    private JLabel charCountLabel, mousePositionLabel;
    private JLabel statusLabel;
    private JButton registerBtn, clearFormBtn, clearAllBtn; 
    
    private ArrayList<String> benefits = new ArrayList<>();
    private ArrayList<Employee> employees = new ArrayList<>();
    

    private ButtonGroup empGroup;
    
    public EmployeeManagementTemplate() {
      setTitle("Employee Management System");
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(1200, 700);

      // ===== Header =====
      JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT));
      headerLabel = new JLabel("<html><h1>Employee Management System</h1></html>");
      header.add(headerLabel);
      header.setBackground(new Color(70, 130, 200));
      headerLabel.setForeground(Color.WHITE);
      add(header, BorderLayout.NORTH);

      // TODO 1: Add MouseListener to header for hover effects
      // When mouse enters: change header text to "Employee Records View" and background color to an orange color
      // When mouse exits: revert to original text and color
      header.addMouseListener(new MouseAdapter()
      {
          @Override
          public void mouseEntered(MouseEvent e)
          {
              header.setBackground(Color.ORANGE);
              headerLabel.setText("<html><h1>Employee Records View</h1></html>");
          }
          @Override
          public void mouseExited(MouseEvent e)
          {
              header.setBackground(new Color(70, 130, 200));
              headerLabel.setText("<html><h1>Employee Management System</h1></html>");
          }
      });

      // ===== Sidebar =====
      JPanel sidebar = new JPanel();
      sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
      sidebar.setPreferredSize(new Dimension(200, 0));
      sidebar.setBackground(new Color(240, 240, 240));
      sidebar.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

      JButton addBtn = new JButton("Add Employee");
      JButton viewBtn = new JButton("View Employees");
      JButton updateBtn = new JButton("Update Employee");
      JButton deleteBtn = new JButton("Delete Employee");
      JButton searchBtn = new JButton("Search Employee");

      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(addBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(viewBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(updateBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(deleteBtn);
      sidebar.add(Box.createRigidArea(new Dimension(0, 10)));
      sidebar.add(searchBtn);
      sidebar.add(Box.createVerticalGlue());

      add(sidebar, BorderLayout.WEST);

      // ===== Form Panel =====
      JPanel form = new JPanel();
      form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
      form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      form.setBackground(Color.WHITE);

      // TODO 2: Add MouseMotionListener to form panel
      // When mouse moves, update mousePositionLabel with coordinates
      addMouseMotionListener(new MouseMotionAdapter()
      {
          @Override
          public void mouseMoved(MouseEvent e)
           {
               mousePositionLabel.setText("Mouse moved at: "+e.getX() + ","+e.getY());
           }
        });
        
      // Name Field
      nameField = new JTextField(20);
      nameField.setText("Enter full name");
      JPanel namePanel = createFieldPanel("Full Name:", nameField);
      form.add(namePanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));
      // TODO 3: Add FocusListener to name field
      // When focused gained, if text is "Enter full name", clear it and set text color to black
      // When focus lost, if text is empty, set it to "Enter full name" and text color to gray
      nameField.addFocusListener(new FocusAdapter() 
      {
        @Override
        public void focusGained(FocusEvent e) {
            if (nameField.getText().equals("Enter full name")) {
                nameField.setText("");
                nameField.setForeground(Color.BLACK);
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (nameField.getText().isEmpty()) {
                nameField.setText("Enter full name");
                nameField.setForeground(Color.GRAY);
            }
        }
        });
      
      // Salary Field
      salaryField = new JTextField(20);
      JPanel salaryPanel = createFieldPanel("Salary", salaryField);
      form.add(salaryPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));
      
      
      /*
      
      salaryField.addKeyListener(new KeyAdapter()
      {
          @Override
          public void keyTyped(KeyEvent e)
          {
              char c= e.getKeyChar();
              if(!Character.isDigit(c) && c !='.')
              {
                  e.consume();// block words and other keys except digits and dots
              }
          }
      });
      */

      // Employment Type
      JPanel employmentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      employmentPanel.add(new JLabel("Employment Type:"));
      fullTime = new JRadioButton("Full-Time");
      partTime = new JRadioButton("Part-Time");
      contract = new JRadioButton("Contract");
      empGroup = new ButtonGroup();
      empGroup.add(fullTime);
      empGroup.add(partTime);
      empGroup.add(contract);
      employmentPanel.add(fullTime);
      employmentPanel.add(partTime);
      employmentPanel.add(contract);
      form.add(employmentPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Benefits
      JPanel benefitsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      benefitsPanel.add(new JLabel("Benefits:"));
      healthInsurance = new JCheckBox("Health Insurance");
      dentalInsurance = new JCheckBox("Dental Insurance");
      retirementPlan = new JCheckBox("Retirement Plan");
      benefitsPanel.add(healthInsurance);
      benefitsPanel.add(dentalInsurance);
      benefitsPanel.add(retirementPlan);
      form.add(benefitsPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Department
      JPanel deptPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      deptPanel.add(new JLabel("Department:"));
      String[] departments = {"IT", "HR", "Finance", "Marketing", "Operations"};
      departmentBox = new JComboBox<>(departments);
      deptPanel.add(departmentBox);
      form.add(deptPanel);
      form.add(Box.createRigidArea(new Dimension(0, 10)));

      // Action Buttons
      registerBtn = new JButton("Register Employee");
      clearFormBtn = new JButton("Clear Form");
      clearAllBtn = new JButton("Clear All Records");

      JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
      btnPanel.add(registerBtn);
      btnPanel.add(clearFormBtn);
      btnPanel.add(clearAllBtn);
      form.add(btnPanel);

      add(form, BorderLayout.CENTER);
      
      registerBtn.addActionListener(this);
      
      clearFormBtn.addActionListener(new ActionListener()
        {
            @Override 
            public void actionPerformed(ActionEvent e)
            {
                clearForm();
            }
        });

      clearFormBtn.addActionListener(this);
      clearAllBtn.addActionListener(this);
      
      // ===== Display Area =====
      JPanel rightPanel = new JPanel(new BorderLayout());
      rightPanel.setPreferredSize(new Dimension(400, 0));

      displayArea = new JTextArea(20, 30);
      displayArea.setEditable(false);
      displayArea.setWrapStyleWord(true);
      displayArea.setLineWrap(true);
      
      displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
      displayArea.setBackground(new Color(252, 252, 252));
      rightPanel.add(new JScrollPane(displayArea), BorderLayout.CENTER);
      add(rightPanel, BorderLayout.EAST);

      // ===== Footer =====
      JPanel footer = new JPanel(new GridLayout(1, 2));
      footer.setBackground(new Color(60, 60, 60));
      footer.setPreferredSize(new Dimension(0, 60));

      charCountLabel = new JLabel("<html><h3>Characters: 0</h3></html>");
      mousePositionLabel = new JLabel("<html><h3>Mouse Position: (0, 0)</h3></html>");
      statusLabel = new JLabel("<html><h3>Status: Ready</h3></html>");

      charCountLabel.setForeground(Color.WHITE);
      mousePositionLabel.setForeground(Color.WHITE);
      statusLabel.setForeground(Color.WHITE);

      JPanel leftFooter = new JPanel(new FlowLayout(FlowLayout.LEFT));
      leftFooter.setBackground(new Color(60, 60, 60));
      leftFooter.add(charCountLabel);
      leftFooter.add(mousePositionLabel);

      JPanel rightFooter = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      rightFooter.setBackground(new Color(60, 60, 60));
      rightFooter.add(statusLabel);

      footer.add(leftFooter);
      footer.add(rightFooter);
      add(footer, BorderLayout.SOUTH);

      setVisible(true);
    }

    private JPanel createFieldPanel(String label, JTextField field) {
      JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      JLabel jlabel = new JLabel(label);
      jlabel.setPreferredSize(new Dimension(120, 25));
      panel.add(jlabel);
      field.setPreferredSize(new Dimension(300, 30));
      panel.add(field);
      panel.setBackground(Color.WHITE);
      return panel;
    }

    // Register Employee Method
   

    public static void main(String[] args) {
      SwingUtilities.invokeLater(() -> new EmployeeManagementTemplate());
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == registerBtn){
            try{
                handleSubmit();
                
            }
            catch(IllegalArgumentException ee)
            {
                JOptionPane.showMessageDialog(this, ee.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                if(ee.getMessage().equals("Name cannot be empty.")){
                    nameField.requestFocus();
                }
                
                if(ee.getMessage().equals("Salary cannot be empty.")){
                    salaryField.requestFocus();
                } 
                
            
            }
            catch(InvalidEmployeeDataException ea)
            {
                JOptionPane.showMessageDialog(this, ea.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
                
                if(ea.getMessage().equals("Salary cannot be less than or equal to 0")){
                    salaryField.requestFocus();
                } 
            }
            
        }
        
        if(e.getSource() == registerBtn)
        {
            handleSubmit();
        }
        else if(e.getSource() == clearFormBtn)
        {
        clearForm();
        }
       else if(e.getSource() == clearAllBtn)
       {
        employees.clear();
        displayArea.setText("");
        }
    }
    public void handleSubmit(){
        String name = nameField.getText().trim();
        
        if(name.isEmpty() || name.equals("Enter full name"))
        {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        String salaryText = salaryField.getText().trim();
        
        
        if(salaryText.isEmpty())
        {
            throw new IllegalArgumentException("Salary cannot be empty.");
        }
        
        double salary= Double.parseDouble(salaryText);
        
        if(salary < 0)
        {
            throw new InvalidEmployeeDataException("Salary cannot be less than or equal to 0");
           
        }
        
        
        String employmentType = "";
        String departments = (String) departmentBox.getSelectedItem();
        
        if(fullTime.isSelected())
        {
            employmentType += fullTime.getText();
        }
        else if(partTime.isSelected())
        {
            employmentType += partTime.getText();
        }
        else{
            employmentType += contract.getText();
        }
        
        if(departments == null){
            throw new IllegalArgumentException("Please select one employement type");
        }
        
        
        if(healthInsurance.isSelected())
        {
            benefits.add(healthInsurance.getText());
        }
        else if(dentalInsurance.isSelected())
        {
            benefits.add(dentalInsurance.getText());
        }
        else
        {
            benefits.add(retirementPlan.getText());
        }
        
        Employee emp = new Employee(name,salary,employmentType,benefits,departments);
        employees.add(emp);
        
        if(emp == null)
        {

            
        
        }
        
        displayArea.append(emp.toString()+ "\n");
        registerBtn.setEnabled(false);
    }
    public void clearForm()
    {
        nameField.setText("");
        salaryField.setText("");
        empGroup.clearSelection();
        departmentBox.setSelectedIndex(0);
        healthInsurance.setSelected(false);
        dentalInsurance.setSelected(false);
        retirementPlan.setSelected(false);
    }
    
}