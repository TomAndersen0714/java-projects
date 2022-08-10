package cn.tomandersen.java.core_java.chapter04;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TimeAPI {
    static void DateDemo() {
        System.out.println("This is a Date Class Demo: ");
        // Date
        // this class only represent a Unix timestamp, not the time on calendar
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); // returns the number of milliseconds since the epoch
    }

    static void LocalDateDemo() {
        System.out.println("This is a LocalDate Class Demo: ");
        // LocalDate
        // this class is using to represent the time on calendar, which may be different in various region around the world
        // you can only create a LocalDate object using the built-in factory method
        LocalDate nowLocalDate = LocalDate.now();
        // obtains the current date from the system clock in the default time-zone

        // LocalDate object is not mutable, every operation would create a new object
        LocalDate newLocalDate = nowLocalDate.plusDays(10);
        newLocalDate = nowLocalDate.minusDays(10).plusWeeks(1);
        System.out.println(newLocalDate.getYear()); // get* method is named 'accessor method'
        System.out.println(newLocalDate.getMonth()); // get the name of month
        System.out.println(newLocalDate.getMonthValue()); // get the number of month
        System.out.println(newLocalDate.getDayOfMonth());
        System.out.println(newLocalDate.getDayOfWeek());

        System.out.println(newLocalDate.lengthOfMonth()); // get the number of days of current month
        System.out.println(newLocalDate.lengthOfYear()); // get the number of days of current year
    }

    static void ZoneIdDemo() {
        System.out.println("This is a Clock Class Demo: ");
        // get the default timezone info
        System.out.println(ZoneId.systemDefault());
    }

    static void printCalendarTest() {
        LocalDate localDate = LocalDate.now();
        int daysOfMonth = localDate.lengthOfMonth();
        int currentDayOfMonth = localDate.getDayOfMonth();

        // get the start date of month
        LocalDate startDayOfMonthLocalDate = localDate.minusDays(currentDayOfMonth - 1);
        // get the number of day of week, Mon=1, Tue=2...
        int numOfFirstDayOfWeek = startDayOfMonthLocalDate.getDayOfWeek().getValue();
        // print the empty placeholder first
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < numOfFirstDayOfWeek; i++) {
            System.out.print("   ");
        }

        // print the number of days in current month
        int numOfDayOfWeek = numOfFirstDayOfWeek;
        for (int i = 1; i <= daysOfMonth; i++) {
            System.out.printf("%3d", i);
            if (i == currentDayOfMonth) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (numOfDayOfWeek % 7 == 0) System.out.println();
            numOfDayOfWeek++;
        }
    }

    public static void main(String[] args) {
        // Unix timestamp 仅仅是表示与 UTC 时间的时间距离, 本身并不具备时区的概念
        // 只是在转换为对应时区的时间时, 需要进行时区的对齐, 即增加或减少一定的时间长度
//        DateDemo();
//        LocalDateDemo();
//        ZoneIdDemo();
        printCalendarTest();

    }
}
