package class7;

import class7.model.Employee;
import class7.model.EmployeeFileHandler;
import class7.model.User;
import class7.model.UserFileHandler;
import class7.view.LoginFrame;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame("Login",null);
            loginFrame.setVisible(true);
                }
                );
    }
    private static void generateAndWriteTestData(int numEmployees) {
        Random random = new Random();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < numEmployees; i++) {
            int id = 10000 + random.nextInt(90000);
            String name = "张" + (char)(random.nextInt(26) + 'A');
            int age = random.nextInt(30) + 20;
            double salary = random.nextDouble() * 10000 + 5000;
            LocalDate entryTime = LocalDate.now().minusDays(random.nextInt(3650));

            Employee employee = new Employee(
                    id,
                    name,
                    age,
                    salary,
                    entryTime.format(formatter)
            );

            EmployeeFileHandler.writeEmployee(employee);
        }
    }

    void createUIComponents(){

    }
}