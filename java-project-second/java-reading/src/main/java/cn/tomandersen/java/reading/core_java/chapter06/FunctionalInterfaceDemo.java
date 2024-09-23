package cn.tomandersen.java.reading.core_java.chapter06;

import java.util.LinkedList;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @see java.util.function.Predicate
 * @see java.util.function.Supplier
 * @see java.util.function.Consumer
 * @see java.util.function.Function
 * @see java.util.function.IntFunction
 * @see java.util.function.IntToLongFunction
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        // java.util.function.Predicate
        // receive a type parameter and a corresponding formal parameter, return a boolean value
        System.out.println("java.util.function.Predicate: ");
        LinkedList<String> staffs = new LinkedList<>();
        staffs.add("Tom");
        staffs.add("Alise");
        staffs.add("Jimmy");
        System.out.println(staffs);
        staffs.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.equals("Tom") || s.equals("John");
            }
        });
        System.out.println(staffs);

        // java.util.function.Supplier
        // receive a type parameter for the return value, and no formal parameter
        System.out.println("java.util.function.Supplier: ");
        String emptyStr = null;
        String res = Objects.requireNonNullElseGet(emptyStr, new Supplier<String>() {
            @Override
            public String get() {
                return staffs.getFirst();
            }
        });
        System.out.println(res);
    }
}
