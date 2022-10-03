package cn.tomandersen.java.reading.core_java.chapter06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.Predicate;

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
        System.out.println("java.util.function.Predicate Demo: ");
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
    }
}
