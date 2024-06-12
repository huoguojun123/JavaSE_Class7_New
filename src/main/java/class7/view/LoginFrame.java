package class7.view;

import class7.controller.LoginController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class LoginFrame extends JFrame{
    private JPanel mainPanel;
    private JLabel welcomeMsg;
    private JLabel loginPoint;
    private JTextField idTextField;
    private JPasswordField passwordField;
    private JLabel idMsg;
    private JLabel passwordMsg;
    private JButton resetButton;
    private JButton loginButton;

    public LoginFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
        this.pack();
        this.setContentPane(mainPanel);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.login(LoginFrame.this);
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void reset(){
        idTextField.setText("");
        passwordField.setText("");

    }
    public JTextField getIdTextField() {
        return idTextField;
    }

    public void setIdTextField(JTextField idTextField) {
        this.idTextField = idTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }


    public void setLoginStatus(String 用户名或密码错误) {
    }


}
