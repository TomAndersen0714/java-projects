package cn.tomandersen.java.reading.core_java.chapter06;

import java.lang.Comparable;
import java.util.Arrays;

public class ComparableDemo {
    public static void main(String[] args) {
        Employee[] staffs = new Employee[3];

        staffs[0] = new Employee("Tom", 35000);
        staffs[1] = new Employee("Alise", 75000);
        staffs[2] = new Employee("Jimmy", 38000);

        Arrays.sort(staffs);

        // print out information about all Employee objects
        for (Employee e : staffs) {
            System.out.println("name=" + e.getName() + ", salary=" + e.getSalary());
        }
    }

    static class Employee implements Comparable<Employee> {

        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return this.name;
        }

        public double getSalary() {
            return this.salary;
        }

        public void raiseSalaryByPercent(double percent) {
            double raise = salary * percent / 100;
            salary += raise;
        }

        /**
         * Compares employees by salary
         *
         * @param o another Employee object
         * @return a negative value if this employee has a lower salary than other Object, 0 if the salaries
         * are same, a positive value otherwise
         */
        @Override
        public int compareTo(Employee o) {
            return Double.compare(this.salary, o.salary);
        }
    }

}

