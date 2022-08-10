package cn.tomandersen.java.core_java.chapter04;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeAPI {
    static void DateDemo() {
        System.out.println("This is a Date Class Demo: ");
        // Date
        // this class only represent a Unix timestamp, not the time on calendar
        // Unix timestamp仅仅是表示与UTC时间的距离, 并不具备时区的概念
        // 只是在转换为对应时区的时间时, 需要进行时区的对齐, 即增加或减少一定的小时数
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); // returns the number of milliseconds since the epoch
    }

    static void LocalDateDemo() {
        System.out.println("This is a LocalDate Class Demo: ");
        // LocalDate
        // this class is using to represent the time on calendar, which may be different in various region around the world
        // you can only create a LocalDate object using the built-in factory method to

        LocalDate nowLocalDate = LocalDate.now();
        // obtains the current date from the system clock in the default time-zone

        System.out.println(nowLocalDate);
        System.out.println(nowLocalDate.getYear());
        System.out.println(nowLocalDate.getMonth());
        System.out.println(nowLocalDate.getDayOfMonth());
        System.out.println(nowLocalDate.getDayOfWeek());

        LocalDate newLocalDate = nowLocalDate.plusDays(10);
        System.out.println(newLocalDate.getYear()); // get* method is named 'accessor method'
        System.out.println(newLocalDate.getMonth());
        System.out.println(newLocalDate.getDayOfMonth());
        System.out.println(newLocalDate.getDayOfWeek());
    }

    static void ZoneIdDemo() {
        System.out.println("This is a Clock Class Demo: ");
        // ZoneId
        System.out.println(ZoneId.systemDefault());
    }

    public static void main(String[] args) {
        DateDemo();
        LocalDateDemo();
        ZoneIdDemo();
    }
}
