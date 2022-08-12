package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

public class MethodInClass {
    // static field
    private static int nextId = 1; // static variable(field)
    private static final int idDelta = 1; // static final variable(field)

    // instance field
    private int id;
    private Date date;


    // static method
    public static int getNextId() {
        System.out.println("This is a static method!");
        int id = nextId;
        nextId += idDelta;
        return id;
    }

    // instance method
    public void setId(int id) { // mutator method
        this.id = id;
    }

    public int getId() { // accessor method (field accessor)
        return this.id;
    }

    public Date getDate() { // accessor method (field accessor)
        // Don't return mutable object in accessor, but a clone of which.
        // And the clone method of class Object is shallow copy, not deep copy
        return (Date) date.clone();
        // 访问器方法(accessor method)在返回可变对象(mutable object)时, 应该返回的是其拷贝, 而不应该返回其
        // 原始可变对象, 使得对象的内部字段在对象的外部进行访问, 这样会破坏类的封装(encapsulation)
        // 创建对象的拷贝一般使用clone方法, 但 Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎,
        // 如果要实现深拷贝, 则需要覆盖 clone 方法, 实现域对象的深度遍历式拷贝
    }


    // constructor method
    public MethodInClass(int id) {
        System.out.println("This is a constructor method!");
        // 'this' is implicit argument, and 'id' is explicit argument
        this.id = id;
    }

    public boolean equals(MethodInClass other) {
        // instance method can access any instance field of same class, no matter if it's the same object
        // 实例方法不仅可以访问当前对象的所有实例字段, 也可以访问另一个同类对象的所有实例字段
        return this.id == other.id;
    }

    // static method (class method)
    public static void main(String[] args) {
        System.out.println("This is static method main!");
        System.out.println(getNextId());
    }
}
