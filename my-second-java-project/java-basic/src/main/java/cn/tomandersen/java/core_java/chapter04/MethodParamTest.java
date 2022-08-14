package cn.tomandersen.java.core_java.chapter04;

public class MethodParamTest {
    /**
     * This program demonstrates parameter passing in Java
     */
    public static void main(String[] args) {
        /*
        Test 1: Methods can't modify numeric or boolean type parameters
         */
        System.out.println("Testing tripleValue: ");
        double percent = 10d;
        System.out.println("Before: percent " + percent);
        tripleValue(percent);
        System.out.println("After: percent " + percent);

        /*
        Test 2: Methods can change the state of object parameters
         */
        System.out.println("Testing tripleSalary: ");
        Employee harry = new Employee("Harry", 40000);
        System.out.println("Before: salary " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary " + harry.getSalary());

        /*
        Test 3: Methods can't attach new object to object parameter
         */
        System.out.println("Testing swap: ");
        Employee a = new Employee("Alise", 1000);
        Employee b = new Employee("Bob", 2000);
        System.out.println("Before: a.name " + a.getName());
        System.out.println("Before: b.name " + b.getName());
        swapObject(a, b);
        System.out.println("Before: a.name " + a.getName());
        System.out.println("Before: b.name " + b.getName());

    }

    public static void tripleValue(double x) {
        x = 3 * x;
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
    }

    public static void swapObject(Employee x, Employee y) {
        Employee tmp;
        tmp = x;
        x = y;
        y = tmp;
    }
}
