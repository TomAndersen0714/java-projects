package library.lang;

import java.util.Objects;

/**
 * @author TomAndersen
 * @see java.lang.ClassLoader
 */
public class ClassLoaderAPI {
    public static void main(String[] args) {
        // NOTE: instance method
        ClassLoader classLoader = ClassLoaderAPI.class.getClassLoader();

        String userDir = System.getProperty("user.dir");
        System.out.println("user dir: " + userDir);

        String classPath = System.getProperty("java.class.path");
        System.out.println("java class path: " + classPath);
        System.out.println();


        // getResource()
        // NOTE: The ClassLoader getResource method only searches for resource files that are represented
        //  using a relative path relative to the classpath, i.e. only search the path string
        //  that not start with '/'.
        String pathString = "text/test.txt";
        System.out.println("classLoader.getResource(\"\") = " + classLoader.getResource(""));
        System.out.println("classLoader.getResource(pathString) = " + classLoader.getResource(pathString));
        System.out.println("classLoader.getResource(pathString).getPath() = " + Objects.requireNonNull(classLoader.getResource(pathString)).getPath());

        // getResourceAsStream()
        System.out.println("classLoader.getResourceAsStream(pathString) = " + classLoader.getResourceAsStream(pathString));

    }
}
