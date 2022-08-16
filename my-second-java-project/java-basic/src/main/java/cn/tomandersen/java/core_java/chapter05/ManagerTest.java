package cn.tomandersen.java.core_java.chapter05;

/**
 * This program demonstrates inheritance.
 */
public class ManagerTest {
    public static void main(String[] args) {
        // construct a Manager object
        Manager manager = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        manager.setBonus(5000);

        Employee[] staffs = new Employee[3];

        // fill the staff array with Manager and Employee objects
        staffs[0] = manager;
        staffs[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staffs[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        // print out information about all Employee objects
        for (Employee employee : staffs) {
            System.out.println("Name: " + employee.getName()
                    + ", salary: " + employee.getSalary()
                    + ", hire date: " + employee.getHireDate());
        }
    }

}
