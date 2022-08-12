package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

// 如果类中所有的方法都不会改变其对象, 这样的类就是不可变类(Immutable class)
final class ImmutableClass {
    // 不可变类(Immutable class)不提供修改器方法, 其对象一旦构造完成, 将不可再修改任何实例字段值
    private final Date date;

    public ImmutableClass() {
        this.date = new Date();
    }

    public Date getDate() {
        return (Date) date.clone();
    }
    // 访问器方法(accessor method)在返回可变对象(mutable object)时, 应该返回的是其拷贝, 而不应该返回其
    // 原始可变对象, 使得对象的内部字段在对象的外部进行访问, 这样会破坏类的封装(encapsulation)
    // 创建对象的拷贝一般使用clone方法, 但 Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎,
    // 如果要实现深拷贝, 则需要覆盖 clone 方法, 实现域对象的深度遍历式拷贝
}
