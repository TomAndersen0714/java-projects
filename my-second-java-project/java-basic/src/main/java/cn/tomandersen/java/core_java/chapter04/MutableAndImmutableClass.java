package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

public class MutableAndImmutableClass {
    public static void main(String[] args) {

    }
}

class MutableClass {
    // instance field
    private Date date;

    // setter method (mutator method)
    // 可变类(mutable class)会提供修改器方法
    public void setDate(Date date) {
        this.date = date;
    }

    // getter method (accessor method)
    // 返回可变对象时, 尽量使用clone方法, 返回其拷贝, 避免破坏封装特性
    public Date getDate() {
        // clone method of object is shallow copy, not deep copy
        return (Date) date.clone();
        // Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎, 如果要实现深拷贝, 则需要覆盖 clone 方法
        // 实现域对象的深度遍历式拷贝
    }
}

final class ImmutableClass {
    // 不可变类(Immutable class)不提供修改器方法, 其对象一旦构造完成, 将不可再修改任何字段值
    private final Date date;

    public ImmutableClass() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }
}
