package libraries.java.lang;

import java.util.Objects;

/**
 * @author TomAndersen
 * @see java.lang.ClassLoader
 */
public class ClassLoaderAPI {
    public static void main(String[] args) {
        // note: instance method
        ClassLoader classLoader = ClassLoaderAPI.class.getClassLoader();

        // getResource()
        System.out.println("classLoader.getResource(\"test.txt\") = " + classLoader.getResource("test.txt"));
        System.out.println("classLoader.getResource(\"test.txt\").getPath() = " +
            Objects.requireNonNull(classLoader.getResource("test.txt")).getPath());

    }
}
