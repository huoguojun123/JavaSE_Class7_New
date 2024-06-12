package class7.view;

import class7.controller.EmployeeController;
import class7.model.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByName extends JFrame{
    private JTextField nameTextField;
    private JButton okButton;
    private JButton resetButton;
    private JPanel mainPanel;

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public void setNameTextField(JTextField nameTextField) {
        this.nameTextField = nameTextField;
    }

    public SearchByName(String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setSize(400,300);
    okButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            EmployeeController.searchByName(SearchByName.this);
        }
    });
}
}
