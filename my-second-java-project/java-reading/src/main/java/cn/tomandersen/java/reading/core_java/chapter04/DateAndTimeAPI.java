package cn.tomandersen.java.reading.core_java.chapter04;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * https://docs.oracle.com/javase/tutorial/datetime/index.html
 * https://docs.oracle.com/javase/tutorial/datetime/TOC.html
 */
public class DateAndTimeAPI {
    public static void main(String[] args) {
        // Unix timestamp 仅仅是表示与 UTC 时间的时间距离, 本身并不具备时区的概念
        // 只是在转换为对应时区的时间时, 需要进行时区的对齐, 即增加或减少一定的时间长度
        DateAPI.demo();
        LocalDateAPI.demo();
        ZoneIdAPI.demo();
        CalendarPrintDemo.demo();
    }
}

/**
 * {@link java.util.Date}
 */
class DateAPI {
    static void demo() {
        System.out.println("This is a Date class api demo: ");
        // Date
        // this class only represent a Unix timestamp, not the time on calendar
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); // returns the number of milliseconds since the epoch
    }
}

/**
 * {@link java.time.LocalDate}
 */
class LocalDateAPI {
    static void demo() {

        System.out.println("This is a LocalDate class api demo: ");
        // this class is using to represent the time on calendar, which may be different in various region around the world

        // initiate LocalDate
        // you can only create a LocalDate object using the built-in factory method
        // 1. obtains the current date from the system clock in the default time-zone
        LocalDate nowLocalDate = LocalDate.now();
        System.out.println(nowLocalDate);
        // 2. initialize LocalDate using LocalDate.of()
        LocalDate localDate = LocalDate.of(2020, 10, 3);
        System.out.println(localDate);

        // LocalDate object is immutable, and every operation would create a new object
        LocalDate newLocalDate = nowLocalDate.minusDays(10).plusWeeks(1);

        // get* method
        System.out.println(newLocalDate.getYear()); // get the year value field
        System.out.println(newLocalDate.getMonthValue()); // get the month value field
        System.out.println(newLocalDate.getMonth()); // get the name of month
        System.out.println(newLocalDate.getDayOfMonth());
        System.out.println(newLocalDate.getDayOfWeek());

        // length* mothod
        System.out.println(newLocalDate.lengthOfMonth()); // get the number of days of current month
        System.out.println(newLocalDate.lengthOfYear()); // get the number of days of current year

    }
}

/**
 * {@link java.time.ZoneId}
 */
class ZoneIdAPI {
    static void demo() {
        System.out.println("This is a ZoneId class demo: ");
        // get the default timezone info
        System.out.println(ZoneId.systemDefault());
    }
}

class CalendarPrintDemo {
    static void demo() {
        LocalDate nowLocalDate = LocalDate.now();
        int daysOfMonth = nowLocalDate.lengthOfMonth();
        int currentDayOfMonth = nowLocalDate.getDayOfMonth();

        // get the start date of month
        LocalDate startDayOfMonthLocalDate = nowLocalDate.minusDays(currentDayOfMonth - 1);
        // get the number of day of week, Mon=1, Tue=2...
        int numOfFirstDayOfWeek = startDayOfMonthLocalDate.getDayOfWeek().getValue();
        // print the empty placeholder first
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < numOfFirstDayOfWeek; i++) {
            System.out.print("   ");
        }

        // print the number of day in current month
        int numOfDayOfWeek = numOfFirstDayOfWeek;
        for (int i = 1; i <= daysOfMonth; i++) {
            System.out.printf("%3d", i);
            if (i == currentDayOfMonth) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
            if (numOfDayOfWeek % 7 == 0) System.out.println();
            numOfDayOfWeek++;
        }
    }
}
