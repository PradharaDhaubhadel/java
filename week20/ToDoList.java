package week20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * Write a description of class ToDoList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ToDoList extends JFrame implements ActionListener
{
    private JPanel titlePanel, taskPanel, formPanel, resultPanel;
    private JPanel row1, row2;
    
    private JLabel label, nameLbl;
    private JTextField txtField;
    private JComboBox<String> prioritiesBox;
    
    private JTextArea displayArea;

    private JButton taskBtn, doneBtn, clearBtn;   
    
    private JCheckBox taskBox;
    
    private ArrayList<String> TaskList = new ArrayList<>();
    public ToDoList()
    {
        setTitle("My ToDo Manager");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        titlePanel = new JPanel();
        label = new JLabel("My ToDo Manager");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        titlePanel.setBackground(new Color(173, 216, 230));
        titlePanel.add(label);
        
        add(titlePanel, BorderLayout.NORTH);
        
        // FORM PANEL
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        // ROW 1
        row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.setAlignmentX(Component.LEFT_ALIGNMENT);

        nameLbl = new JLabel("Task:");
        txtField = new JTextField(15);
        
        String[] priority ={"High","Medium","Low"};
        prioritiesBox = new JComboBox<>(priority);
        
        taskBtn = new JButton("Add Task");
        taskBtn.setBackground(Color.green);
    
        row1.add(nameLbl);
        row1.add(Box.createHorizontalStrut(10));
        row1.add(txtField);
        
        row1.add(Box.createHorizontalStrut(15));
        row1.add(prioritiesBox);
        
        row1.add(Box.createHorizontalStrut(15));
        row1.add(taskBtn);
        
        formPanel.add(row1);
        add(formPanel, BorderLayout.CENTER);
        
        taskBtn.addActionListener(this);
        
        
        //row2
        row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.Y_AXIS)); 
        row2.setBackground(Color.LIGHT_GRAY);
        row2.setBorder(BorderFactory.createEmptyBorder(3,3,3,3));
        
        doneBtn = new JButton("Done");
        doneBtn.setBackground(Color.RED);
        doneBtn.setAlignmentX(Component.CENTER_ALIGNMENT); 
        doneBtn.addActionListener(e ->
        {
            for (int i = 0; i < resultPanel.getComponentCount(); i++) {
                JCheckBox box = (JCheckBox) resultPanel.getComponent(i);
                box.setSelected(true); 
                
                String text = box.getText();
                box.setText("<html><strike>" + text + "</strike></html>");
            }
        });
        
        clearBtn = new JButton("Clear All");
        clearBtn.setBackground(Color.GREEN);
        clearBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        clearBtn.addActionListener(e -> 
        {
            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to delete all tasks?",
                "Confirm Clear",
                JOptionPane.YES_NO_OPTION
            );
            if (choice == JOptionPane.YES_OPTION) {
                TaskList.clear();
                resultPanel.removeAll();
                resultPanel.revalidate();
                resultPanel.repaint();
            }
        });
        
        row2.add(Box.createVerticalStrut(10));
        row2.add(doneBtn);
        row2.add(Box.createVerticalStrut(10));
        row2.add(clearBtn);
        
        add(row2, BorderLayout.EAST);
        
        
        // RESULT PANEL
        resultPanel = new JPanel();
        resultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(resultPanel, BorderLayout.SOUTH);
        resultPanel.setPreferredSize(new Dimension(100,100));
    
        JScrollPane scrollPane = new JScrollPane(resultPanel);
        scrollPane.setPreferredSize(new Dimension(50,50));
        add(scrollPane, BorderLayout.SOUTH);

        pack();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == taskBtn){
            handleSubmit();
        }
    }
    
    public void handleSubmit(){
        String task = txtField.getText().trim();
        if (task.isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Task");
            return;
        }
        String priority = (String) prioritiesBox.getSelectedItem();
        String taskWithPriorities = task+" ("+priority+")" ;
        TaskList.add(taskWithPriorities);
        
        resultPanel.removeAll();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        
        for(String todo : TaskList){
            JCheckBox taskBox = new JCheckBox(todo);
            resultPanel.add(taskBox);
        }
        
        resultPanel.revalidate();
        resultPanel.repaint();
        txtField.setText("");
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(()->
        {
           new ToDoList().setVisible(true); 
        });
    }

}
