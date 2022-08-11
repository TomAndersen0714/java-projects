package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;
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

    // a final instance field must be initiated in constructor, and cannot be changed in future
    // final实例字段, 必须在构造函数中进行赋值, 并且一旦赋值, 之后将再也不能更改
    private final LocalDate hireDate;

    private Date date;

    // constructor
    public Employee(String name, double salary, int year, int month, int day) {
        // 'this' 是对象方法的固定隐式(implicit)参数, 而 name/salary 等则属于显式(explicit)参数
        this.name = name;
        this.salary = salary;
        this.hireDate = LocalDate.of(year, month, day);
        this.date = new Date();
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

    // 访问器方法(accessor method)在返回可变对象(mutable object)时, 应该返回的是其 clone() 结果, 而不应该返回其
    // 原始可变对象, 使得对象的内部字段在对象的外部进行访问, 这样会破坏类的封装(encapsulation)
    public Date getDate() {
        return (Date) date.clone();
    }

    // mutator method
    public void raiseSalary(double byPercent) {
        this.salary += this.salary * byPercent / 100;
    }

    // 同一个类的方法(method), 可以访问基于该类创建的所有对象实例的私有字段(private field), 而非仅仅调用对象自身的私有字段
    public boolean equals(Employee other) {
        return this.name.equals(other.name);
    }
}
