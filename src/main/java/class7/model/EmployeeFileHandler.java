package class7.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeFileHandler {
    private static final String FILE_NAME = "Employees.txt";

    public static List<Employee> readEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                Employee employee = new Employee(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Double.parseDouble(fields[3]),
                        fields[4]
                );
                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 根据工号升序排序
        employees.sort(Comparator.comparingInt(Employee::getId));

        return employees;
    }

    public static void writeEmployee(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/"+FILE_NAME, true))) {
            writer.write(String.format("%d,%s,%d,%.2f,%s",
                    employee.getId(),
                    employee.getName(),
                    employee.getAge(),
                    employee.getSalary(),
                    employee.getEntryTime()));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 根据工号匹配删除
    public static boolean deleteEmployee(int id, String name) {
        List<Employee> employees = readEmployees();
        List<Employee> updatedEmployees = new ArrayList<>();

        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getId() != id || !employee.getName().equals(name)) {
                updatedEmployees.add(employee);
            } else {
                found = true;
            }
        }

        if (found) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/" + FILE_NAME, false))) {
                for (Employee employee : updatedEmployees) {
                    writer.write(String.format("%d,%s,%d,%.2f,%s",
                            employee.getId(),
                            employee.getName(),
                            employee.getAge(),
                            employee.getSalary(),
                            employee.getEntryTime()));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
