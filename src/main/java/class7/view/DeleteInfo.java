package class7.view;

import class7.controller.EmployeeController;
import class7.model.EmployeeFileHandler;

import javax.annotation.processing.Messager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteInfo extends JFrame{
    private JPanel mainPanel;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JButton resetButton;
    private JButton okButton;

    public DeleteInfo(String title, GraphicsConfiguration gc){
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(500, 400);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int employeeId = Integer.parseInt(idTextField.getText());
                String employeeName = nameTextField.getText();
                if (EmployeeFileHandler.deleteEmployee(employeeId, employeeName)) {
                    JOptionPane.showMessageDialog(DeleteInfo.this, "删除成功!");
                    resetForm();
                } else {
                    JOptionPane.showMessageDialog(DeleteInfo.this, "删除失败，请检查输入的工号和姓名", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
    }
    private void resetForm() {
        idTextField.setText("");
        nameTextField.setText("");
    }
}
