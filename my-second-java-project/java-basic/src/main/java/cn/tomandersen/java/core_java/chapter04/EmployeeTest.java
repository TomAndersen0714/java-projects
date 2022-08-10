package cn.tomandersen.java.core_java.chapter04;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeTest {
    /**
     * This program tests the Employee class.
     */
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staffs = new Employee[3];

        staffs[0] = new Employee("Carl Cracker", 20000.0d, 2021, 3, 10);
        staffs[1] = new Employee("Harry Hacker", 10000.0d, 2022, 1, 12);
        staffs[2] = new Employee("Tom Andersen", 30000.0d, 2022, 7, 1);

        // raise everyone's salary by 5%
        for (Employee staff : staffs) {
            staff.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee staff : staffs) {
            System.out.println("name: " + staff.getName() + ", salary: " +
                    staff.getSalary() + ", hire date: " + staff.getHireDate());
        }
    }
}

class Employee {
    // instance fields
    private String name;
    private double salary;
    private LocalDate hireDate;

    // constructor
    public Employee(String name, double salary, int year, int month, int day) {
        // 'this' 是对象方法的固定隐式(implicit)参数, 而 name/salary 等则属于显式(explicit)参数
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
    }

    public Employee(String name, double salary) {
        // 为对象实例字段进行判空处理
        // requireNonNull 要求对应的对象引用一定不能为空
        this.name = Objects.requireNonNull(name, "The name cannot be null!");
        // requireNonNullElse 允许输入的对象引用可以为空, 但是会使用一个默认的对象引用来代替输入值进行 return
        this.name = Objects.requireNonNullElse(name, "unknown");
        this.salary = salary;
        this.hireDate = LocalDate.now();
    }

    // accessor method
    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    // mutator method
    public void raiseSalary(double byPercent) {
        this.salary += this.salary * byPercent / 100;
    }

    public boolean equals(Employee other) {
        // 同一个类的方法(method), 可以访问该类的任何对象实例的私有字段(private field)
        return this.name.equals(other.name);
    }
}
