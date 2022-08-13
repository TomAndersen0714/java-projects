package cn.tomandersen.java.core_java.chapter04;

import java.util.Objects;

public class ObjectsAPI {
    public static void main(String[] args) {
        // equals
        String a = "To";
        String b = "T" + "o";
        System.out.println(Objects.equals(a, b));

        // requireNonNull
        System.out.println(Objects.requireNonNull(a));
        System.out.println(Objects.requireNonNull(a, "This object cannot be null!"));
    }
}
