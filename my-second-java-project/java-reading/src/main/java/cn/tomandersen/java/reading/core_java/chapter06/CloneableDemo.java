package cn.tomandersen.java.reading.core_java.chapter06;

import java.time.*;
import java.util.Date;
import java.util.Objects;

/**
 * This program demonstrates cloning.
 *
 * @author TomAndersen
 * @version 1.0.0
 * @see java.lang.Cloneable
 * @see java.lang.CloneNotSupportedException
 */
public class CloneableDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee original = new Employee("TomAndersen", 16000);
        original.setHireDay(2020, 7, 1);

        Employee cloned = original.clone();
        cloned.raiseSalaryByPercent(30);
        cloned.setHireDay(2022, 12, 1);
        System.out.println("original: " + original);
        System.out.println("cloned: " + cloned);
    }

    static class Employee implements Cloneable {
        private String name;
        private double salary;
        private Date hireDay;

        public Employee(String name, double salary) {
            Objects.requireNonNull(name);
            this.name = name;
            this.salary = salary;
            this.hireDay = new Date();
        }

        @Override
        public Employee clone() throws CloneNotSupportedException {
            // call Object.clone()
            Employee cloned = (Employee) super.clone();
            // clone instance of mutable class explicitly
            cloned.hireDay = (Date) this.hireDay.clone();

            return cloned;
        }

        /**
         * Set the hire day to a given date.
         */
        public void setHireDay(int year, int month, int day) {
            Instant instant = LocalDateTime.of(year, month, day, 0, 0).atZone(ZoneId.systemDefault()).toInstant();
            this.hireDay.setTime(instant.toEpochMilli());
        }

        public void raiseSalaryByPercent(double percent) {
            double raise = this.salary * percent / 100;
            this.salary += raise;
        }

        @Override
        public String toString() {
            return "Employee[name=]" + this.name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
        }
    }
}
