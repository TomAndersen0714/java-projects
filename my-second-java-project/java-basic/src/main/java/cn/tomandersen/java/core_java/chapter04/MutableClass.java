package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

class MutableClass {
    // instance field
    private Date date;

    // 可变类(mutable class)会提供修改器方法(mutator method)
    // 修改器方法 (mutator method)
    public void setDate(Date date) {
        this.date = date;
    }

    // 访问器方法 (accessor method)
    // 返回可变对象时, 需要尽量使用返回其拷贝, 避免破坏封装特性, 一般使用clone方法
    public Date getDate() {
        // clone method of object is shallow copy, not deep copy
        return (Date) date.clone();
        // Object 默认的 clone 方法是浅拷贝, 在使用时候需要谨慎, 如果要实现深拷贝, 则需要覆盖 clone 方法
        // 实现域对象的深度遍历式拷贝
    }
}
