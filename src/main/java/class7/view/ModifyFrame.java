package class7.view;

import class7.controller.EmployeeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifyFrame extends JFrame{
    private JTextField nameTextField;
    private JTextField idTextField;
    private JTextField salaryTextField;
    private JButton okButton;
    private JButton resetButton;
    private JSpinner ageSpinner;
    private JPanel mainPanel;
    private JFormattedTextField entryTimeFormattedTextField;

    public ModifyFrame(String title, GraphicsConfiguration gc){
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(400,300);

        // 设置年龄Spinner的模型
        SpinnerNumberModel ageModel = new SpinnerNumberModel(20, 18, 65, 1);
        ageSpinner.setModel(ageModel);

        resetButton.addActionListener(e -> clearInputs());
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmployeeController.modifyEmployee(ModifyFrame.this);
            }
        });
    }

    private void clearInputs() {
        nameTextField.setText("");
        idTextField.setText("");
        ageSpinner.setValue(20);
        salaryTextField.setText("");
        entryTimeFormattedTextField.setText("");
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JTextField getSalaryTextField() {
        return salaryTextField;
    }

    public void setSalaryTextField(JTextField salaryTextField) {
        this.salaryTextField = salaryTextField;
    }

    public JSpinner getAgeSpinner() {
        return ageSpinner;
    }

    public void setAgeSpinner(JSpinner ageSpinner) {
        this.ageSpinner = ageSpinner;
    }

    public JFormattedTextField getEntryTimeFormattedTextField() {
        return entryTimeFormattedTextField;
    }

    public void setEntryTimeFormattedTextField(JFormattedTextField entryTimeFormattedTextField) {
        this.entryTimeFormattedTextField = entryTimeFormattedTextField;
    }
}
