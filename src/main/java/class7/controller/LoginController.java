package class7.controller;

import class7.model.User;
import class7.model.UserFileHandler;
import class7.view.*;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class LoginController extends UserFileHandler {
    public static void login(LoginFrame loginFrame) {
        int userid = Integer.parseInt(loginFrame.getIdTextField().getText());
        String password = new String(loginFrame.getPasswordField().getPassword());

        System.out.println("Userid: " + userid);
        System.out.println("Password: " + password);


        List<User> users = UserFileHandler.readUsers();
        for (User user : users) {
            // 管理员身份验证
            if ((user.getId() == userid)  && user.getPassword().equals(password) && user.isAdmin()) {
                SwingUtilities.invokeLater(() -> {
                    AdminManagerFrame adminManagerFrame = new AdminManagerFrame("管理员操作", null);
                });
                return;
            }
        }
        loginFrame.setLoginStatus("用户名或密码错误");
    }
}
