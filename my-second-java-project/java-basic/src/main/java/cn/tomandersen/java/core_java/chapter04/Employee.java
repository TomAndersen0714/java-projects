package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Employee {
    // instance fields
    private String name;
    private double salary;
    // a final instance field must be initiated in constructor, and cannot be changed in future
    // final实例字段, 必须在构造函数中进行赋值, 并且一旦赋值, 之后将再也不能更改
    private final Date date;
    private LocalDate hireDate;
    private int id;

    // object initialization block
    {
        this.id = getNextId();
    }

    // static field
    private static int nextId = 1;
    private static final int idDelta = 1; // static final field
    private static Random randomGenerator = new Random();

    // static final field
    public static final String department = "research and development department";

    // static initialization block
    static {
        // set nextId to a random number between 0 and 9999
        nextId = randomGenerator.nextInt(10000);
    }

    // default constructor
    public Employee() {
        this.date = new Date();
        // other instance filed will be set to default value
        // i.e. numeric type will be set to 0, boolean type will be set to false, and
        // object type will be to null
        // 构造函数中, 没有设置实例变量, 将会被赋值为其对应数据类型的默认值, 即数值类型会被设置为0, 布尔类型
        // 会被设置为 false, 对象类型会被设置为 null
        // 然后实例字段以及实例初始化代码块按照在类中声明的顺序, 为其赋值具体值
    }

    // overloaded constructor
    // 重载构造器
    public Employee(String name, double salary) {
        // 为对象实例字段进行判空处理
        // requireNonNull 要求对应的对象引用一定不能为空
        this.name = Objects.requireNonNull(name, "The name cannot be null!");
        // requireNonNullElse 允许输入的对象引用可以为空, 但是会使用一个默认的对象引用来代替输入值进行 return
        this.name = Objects.requireNonNullElse(name, "unknown");
        this.salary = salary;
        this.hireDate = LocalDate.now();
//        this.id = getNextId();
        this.date = new Date();
    }

    // overloaded constructor
    public Employee(String name, double salary, int year, int month, int day) {
        // 'this' 是对象方法的固定隐式(implicit)参数, 而 name/salary 等则属于显式(explicit)参数
        this(name, salary);
        this.hireDate = LocalDate.of(year, month, day);
    }

    // overloaded constructor
    public Employee(String name, double salary, Date date) {
        this.name = Objects.requireNonNullElse(name, "unknown");
        this.salary = salary;
        this.hireDate = LocalDate.now();
        this.id = getNextId();
        this.date = Objects.requireNonNullElse(date, new Date());
    }

    // accessor method
    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return this.salary;
    }

    public LocalDate getHireDate() {
        return this.hireDate;
    }

    // accessor method
    public Date getDate() {
        return (Date) date.clone();
    }
    // 访问器方法(accessor method)在返回可变对象(mutable object)时, 应该返回的是其拷贝, 而不应该返回其
    // 原始可变对象, 使得对象的内部字段在对象的外部进行访问, 这样会破坏类的封装(encapsulation)
    // 创建对象的拷贝一般使用clone方法, 但 Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎,
    // 如果要实现深拷贝, 则需要覆盖 clone 方法, 实现域对象的深度遍历式拷贝

    // mutator method
    public void raiseSalary(double byPercent) {
        this.salary += this.salary * byPercent / 100;
    }

    // 同一个类的方法(method), 可以访问基于该类创建的所有对象实例的私有字段(private field), 而非仅仅调用对象自身的私有字段
    public boolean equals(Employee other) {
        return this.name.equals(other.name);
    }

    public static int getNextId() {
        int id = nextId;
        nextId += idDelta;
        return id;
    }

    /**
     * This program tests the Employee class.
     */
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staffs = new Employee[3];

        staffs[0] = new Employee("Carl Cracker", 20000.0d);
        staffs[1] = new Employee("Harry Hacker", 10000.0d, 2022, 1, 12);
        staffs[2] = new Employee("Tom Andersen", 30000.0d, 2022, 7, 1);

        // raise everyone's salary by 5%
        for (Employee staff : staffs) {
            staff.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee staff : staffs) {
            System.out.println("name: " + staff.getName() + ", id: " + staff.getId() + ", salary: " + staff.getSalary() + ", hire date: " + staff.getHireDate());
        }

        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);
    }
}
