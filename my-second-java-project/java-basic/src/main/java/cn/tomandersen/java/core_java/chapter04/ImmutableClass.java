package cn.tomandersen.java.core_java.chapter04;

import java.util.Date;

final class ImmutableClass {
    // 不可变类(Immutable class)不提供修改器方法, 其对象一旦构造完成, 将不可再修改任何实例字段值
    private final Date date;

    public ImmutableClass() {
        this.date = new Date();
    }

    // 返回可变对象时, 需要尽量使用返回其拷贝, 避免破坏封装特性, 一般使用clone方法
    public Date getDate() {
        return (Date) date.clone();
    }
}
