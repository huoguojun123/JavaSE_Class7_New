package class7.view;

import class7.controller.EmployeeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchByID extends JFrame{
    private JTextField idTextField;
    private JButton okButton;
    private JButton resetButton;
    private JPanel mainPanel;

    public SearchByID(String title, GraphicsConfiguration gc){
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
                EmployeeController.searchByID(SearchByID.this);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void clearInput(){
        idTextField.setText("");
    }
    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }
}
