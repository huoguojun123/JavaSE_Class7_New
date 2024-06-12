package class7.model;

import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String entryTime;


    public Employee(int id, String name, int age, double salary, String entryTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.entryTime = entryTime;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getEntryTime() {
        return entryTime;
    }

}
