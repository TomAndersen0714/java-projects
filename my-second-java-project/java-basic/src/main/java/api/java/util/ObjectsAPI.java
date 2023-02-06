package api.java.util;

import java.util.Objects;

/**
 * {@link java.util.Objects}
 */
public class ObjectsAPI {
    public static void main(String[] args) {
        // equals
        String a = "To";
        String b = "T" + "o";
        System.out.println(Objects.equals(a, b));

        // requireNonNull()
        System.out.println(a);
        System.out.println(Objects.requireNonNull(a, "This object cannot be null!"));
        // requireNonNullElse()
        System.out.println(Objects.requireNonNullElse(a, "unknown"));
        // requireNonNullElseGet()
        System.out.println(Objects.requireNonNullElseGet(a, () -> System.getProperty("os.version")));

        // hashCode()
        System.out.println(Objects.hashCode(a));

        // hash()
        System.out.println(Objects.hash("Tom", "Alise", "Jim"));

    }
}
