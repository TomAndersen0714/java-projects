package lesson1.variable_types;

/**
 * @author TomAndersen
 */
public class Variable {
    public static void main(String[] args) {
        // NOTE: In Java, variables are pointers or references to data.
        String a = "abc";
        System.out.println("a = " + a);

        String b = a;
        a = "123";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
