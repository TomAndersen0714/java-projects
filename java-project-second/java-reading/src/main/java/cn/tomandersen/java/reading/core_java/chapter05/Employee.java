package cn.tomandersen.java.reading.core_java.chapter05;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDate;

    public Employee(String name, double salary, int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String getName() {
        return name;
    }

    public void raiseSalary(double percent) {
        salary = salary * percent / 100 + salary;
    }
}
