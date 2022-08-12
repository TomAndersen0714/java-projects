package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

// 如果类中的方法可以修改实例字段, 则此类被称为可变类(Mutable class)
class MutableClass {
    // instance field
    private Date date;

    // 可变类(mutable class)会提供修改器方法(mutator method)
    // 修改器方法 (mutator method)
    public void setDate(Date date) {
        this.date = date;
    }

    // 访问器方法 (accessor method)
    public Date getDate() {
        // clone method of object is shallow copy, not deep copy
        return (Date) date.clone();
    }
    // 访问器方法(accessor method)在返回可变对象(mutable object)时, 应该返回的是其拷贝, 而不应该返回其
    // 原始可变对象, 使得对象的内部字段在对象的外部进行访问, 这样会破坏类的封装(encapsulation)
    // 创建对象的拷贝一般使用clone方法, 但 Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎,
    // 如果要实现深拷贝, 则需要覆盖 clone 方法, 实现域对象的深度遍历式拷贝
}
