package class7.view;

import class7.controller.EmployeeController;
import class7.model.Employee;
import class7.model.EmployeeFileHandler;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ShowAll extends JFrame {
    private JTable allEmployeesTable;
    private JScrollPane scrollPane;

    // 构造方法
    public ShowAll(String title, GraphicsConfiguration gc) {
        super(title, gc);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        String[] columnNames = {"工号", "姓名", "年龄", "工资", "入职时间"};
        List<Employee> employees = EmployeeFileHandler.readEmployees();
        Object[][] data = new Object[employees.size()][5];

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            data[i][0] = employee.getId();
            data[i][1] = employee.getName();
            data[i][2] = employee.getAge();
            data[i][3] = employee.getSalary();
            data[i][4] = employee.getEntryTime();
        }

        allEmployeesTable = new JTable(data, columnNames);
        scrollPane = new JScrollPane(allEmployeesTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}
