package class7.view;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class AddInfo extends JFrame {
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField idTextField;
    private JSpinner ageSpinner;
    private JTextField salaryTextField;
    private JFormattedTextField entryTimeFormattedTextField;
    private JButton addInfoButton;
    private JButton clearButton;

    // 构造方法
    public AddInfo(String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500, 400);

        // 设置年龄Spinner的模型
        SpinnerNumberModel ageModel = new SpinnerNumberModel(20, 18, 65, 1);
        ageSpinner.setModel(ageModel);

        addInfoButton.addActionListener(e -> class7.controller.EmployeeController.addEmployee(this));
        clearButton.addActionListener(e -> clearInputs());
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void clearInputs() {
        nameTextField.setText("");
        idTextField.setText("");
        ageSpinner.setValue(20);
        salaryTextField.setText("");
        entryTimeFormattedTextField.setText("");
    }

    // Getters and Setters
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getName() {
        return nameTextField.getText().trim();
    }

    public String getId() {
        return idTextField.getText().trim();
    }

    public int getAge() {
        return (Integer) ageSpinner.getValue();
    }

    public String getSalary() {
        return salaryTextField.getText().trim();
    }

    public String getEntryTime() {
        return entryTimeFormattedTextField.getText().trim();
    }
}
