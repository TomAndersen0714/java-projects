package cn.tomandersen.java.reading.core_java.chapter04;

public class ClassConstructorDemo {
    /**
     * This program demonstrates object construction.
     */
    public static void main(String[] args) {
        // fill the staff array with three Employee objects
        Employee[] staffs = new Employee[3];

        staffs[0] = new Employee("Carl Cracker", 20000.0d);
        staffs[1] = new Employee("Harry Hacker", 10000.0d, 2022, 1, 12);
        staffs[2] = new Employee("Tom Andersen", 30000.0d, 2022, 7, 1);

        // raise everyone's salary by 5%
        for (Employee staff : staffs) {
            staff.raiseSalary(5);
        }

        // print out information about all Employee objects
        for (Employee staff : staffs) {
            System.out.println("name: " + staff.getName() + ", id: " + staff.getId() + ", salary: " + staff.getSalary() + ", hire date: " + staff.getHireDate());
        }

        int n = Employee.getNextId();
        System.out.println("Next available id=" + n);

    }
}
