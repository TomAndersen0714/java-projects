package cn.tomandersen.java.reading.core_java.chapter05;

public class ClassAPI {
    public static void main(String[] args) {
        // anonymous class based on extends
        Employee employee = new Employee(
            "TomAndersen", 17000, 2022, 7, 1
        ) {
            @Override
            public String toString() {
                return "name: " + this.getName() + ", "
                    + "salary: " + this.getSalary() + ", "
                    + "hire date: " + this.getHireDate();
            }
        };
        Class<? extends Employee> employeeClass = employee.getClass();


        // getName()
        System.out.println("getName(): ");
        System.out.println(employeeClass.getName());

        // getEnclosingClass()
        System.out.println("getEnclosingClass(): ");
        System.out.println(employeeClass.getEnclosingClass().getName());
    }
}
