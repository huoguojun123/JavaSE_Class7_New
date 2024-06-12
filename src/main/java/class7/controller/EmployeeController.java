package class7.controller;

import class7.model.Employee;
import class7.model.EmployeeFileHandler;
import class7.view.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.List;

public class EmployeeController {

    // 静态方法：录入信息
    public static void addEmployee(AddInfo addInfo) {
        String name = addInfo.getName();
        String idText = addInfo.getId();
        String salaryText = addInfo.getSalary();
        String entryTime = addInfo.getEntryTime();

        if (name.isEmpty()) {
            addInfo.showMessage("姓名不能为空");
            return;
        }

        if (!idText.matches("\\d+")) {
            addInfo.showMessage("ID 必须为数字");
            return;
        }

        int id = Integer.parseInt(idText);

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            addInfo.showMessage("工资必须为有效数字");
            return;
        }

        if (!isValidDate(entryTime)) {
            addInfo.showMessage("入职时间格式不正确（应为 YYYY-MM-DD）");
            return;
        }

        int age = addInfo.getAge();
        Employee employee = new Employee(id, name, age, salary, entryTime);
        EmployeeFileHandler.writeEmployee(employee);
        addInfo.showMessage("员工添加成功");
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 静态方法：根据 ID 查找
    public static void searchByID(SearchByID searchByID) {
        int id = Integer.parseInt(searchByID.getIdTextField().getText());
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            showEmployeeInfoDialog(searchByID, employee);
        } else {
            JOptionPane.showMessageDialog(searchByID, "未找到工号为 " + id + " 的员工", "查询结果", JOptionPane.WARNING_MESSAGE);
        }
    }

    // 静态方法：根据姓名查找
    public static void searchByName(SearchByName searchByName) {
        String name = searchByName.getNameTextField().getText();
        Employee matchingEmployee = getEmployeeByName(name);
        if (matchingEmployee != null) {
            showEmployeeInfoDialog(searchByName, matchingEmployee);
        } else {
            JOptionPane.showMessageDialog(searchByName.getNameTextField(), "未找到姓名为 " + name + " 的员工", "查询结果", JOptionPane.WARNING_MESSAGE);
        }
    }

    // 静态方法：显示单个员工信息对话框
    private static void showEmployeeInfoDialog(SearchByID searchByID, Employee employee) {
        String message = String.format(
                "工号: %d\n姓名: %s\n年龄: %d\n工资: %.2f\n入职时间: %s",
                employee.getId(), employee.getName(), employee.getAge(), employee.getSalary(), employee.getEntryTime()
        );
        JOptionPane.showMessageDialog(searchByID, message, "查询结果", JOptionPane.INFORMATION_MESSAGE);
    }

    // 静态方法：显示单个员工信息对话框
    private static void showEmployeeInfoDialog(SearchByName searchByName, Employee employee) {
        String message = String.format(
                "工号: %d\n姓名: %s\n年龄: %d\n工资: %.2f\n入职时间: %s",
                employee.getId(), employee.getName(), employee.getAge(), employee.getSalary(), employee.getEntryTime()
        );
        JOptionPane.showMessageDialog(searchByName.getNameTextField(), message, "查询结果", JOptionPane.INFORMATION_MESSAGE);
    }

    // 静态方法：获取指定 ID 的员工
    private static Employee getEmployeeById(int id) {
        List<Employee> employees = EmployeeFileHandler.readEmployees();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    // 静态方法：根据姓名获取单个员工
    private static Employee getEmployeeByName(String name) {
        List<Employee> employees = EmployeeFileHandler.readEmployees();
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }

    public static void modifyEmployee(ModifyFrame modifyFrame) {
        String name = modifyFrame.getNameTextField().getText();
        String idText = modifyFrame.getIdTextField().getText();
        String salaryText = modifyFrame.getSalaryTextField().getText();
        String entryTime = modifyFrame.getEntryTimeFormattedTextField().getText();
        int age = (int) modifyFrame.getAgeSpinner().getValue();

        // 进行输入格式验证
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(modifyFrame, "姓名不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!idText.matches("\\d+")) {
            JOptionPane.showMessageDialog(modifyFrame, "ID 必须为数字", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(idText);

        double salary;
        try {
            salary = Double.parseDouble(salaryText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(modifyFrame, "工资必须为有效数字", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!isValidDate(entryTime)) {
            JOptionPane.showMessageDialog(modifyFrame, "入职时间格式不正确（应为 YYYY-MM-DD）", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }
        EmployeeFileHandler.deleteEmployee(id,name);
        Employee employee = new Employee(id, name, age, salary, entryTime);
        EmployeeFileHandler.writeEmployee(employee);
        JOptionPane.showMessageDialog(modifyFrame, "员工信息修改成功", "成功", JOptionPane.INFORMATION_MESSAGE);
    }
}