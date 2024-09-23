package libraries.java.lang;

import java.util.Objects;

/**
 * @author TomAndersen
 * @see java.lang.Class
 */
public class ClassAPI {
    /**
     * @param args
     * @throws ClassNotFoundException
     * @see libraries.java.lang.ClassLoaderAPI
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // NOTE: class method

        // Class.forName()
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("className = " + className);
        Class<?> clazz = Class.forName(className);
        System.out.println("(clazz == ClassAPI.class) = " + (clazz == ClassAPI.class));


        // NOTE: instance method
        String userDir = System.getProperty("user.dir");
        System.out.println("user dir = " + userDir);

        String classPath = System.getProperty("java.class.path");
        System.out.println("java class path: " + classPath);

        // getClassLoader()
        System.out.println("ClassAPI.class.getClassLoader() = " + ClassAPI.class.getClassLoader());


        // getName()
        System.out.println("ClassAPI.class.getName() = " + ClassAPI.class.getName());
        // getSimpleName()
        System.out.println("ClassAPI.class.getSimpleName() = " + ClassAPI.class.getSimpleName());
        // getPackageName()
        System.out.println("ClassAPI.class.getPackageName() = " + ClassAPI.class.getPackageName());


        // getModule()
        System.out.println("ClassAPI.class.getModule() = " + ClassAPI.class.getModule());
        System.out.println("ClassAPI.class.getModule().isNamed() = " + ClassAPI.class.getModule().isNamed());


        // isArray()
        // Determines if this Class object represents an array class.
        int[] nums = new int[]{1, 2, 3};
        Class<? extends int[]> numsClass = nums.getClass();
        System.out.println("numsClass.isArray() = " + numsClass.isArray());
        // getComponentType()
        System.out.println("numsClass.getComponentType() = " + numsClass.getComponentType());
        System.out.println();


        // getResource()
        // NOTE:
        //  If the name is absolute path, i.e. starts with "/", such as "/path/to/resource_file",
        //      the leading '/' will be removed.
        //  If the name is relative path, i.e. not starts with "/", such as "resource_file",
        //      name will be prefixed with package name.
        //  And then will invoke getResource of ClassLoader to get the URL of resource file.
        Class<ClassAPI> classApiClass = ClassAPI.class;
        System.out.println("classApiClass.getResource(\"\") = " + classApiClass.getResource(""));
        System.out.println("classApiClass.getResource(\"/\") = " + classApiClass.getResource("/"));
        System.out.println();

        // search the file in classpath
        String filePath = "/text/test.txt";
        System.out.println("filePath = " + filePath);
        System.out.println("classAPIClass.getResource(filePath) = " + classApiClass.getResource(filePath));
        System.out.println("classAPIClass.getResource(filePath).getPath() = " + Objects.requireNonNull(classApiClass.getResource(filePath)).getPath());
        System.out.println();

        // search the file in classpath+package path
        filePath = "ClassAPI.class";
        System.out.println("filePath = " + filePath);
        System.out.println("classAPIClass.getResource(filePath) = " + classApiClass.getResource(filePath));
        System.out.println("classAPIClass.getResource(filePath).getPath() = " + Objects.requireNonNull(classApiClass.getResource(filePath)).getPath());
        System.out.println();

        // getResourceAsStream()
        // NOTE: same as getResource()
        System.out.println("classApiClass.getResourceAsStream(\"/\") = " + classApiClass.getResourceAsStream("/"));
        System.out.println("classApiClass.getResourceAsStream(\"\") = " + classApiClass.getResourceAsStream(""));
        System.out.println("classAPIClass.getResourceAsStream(filePath) = " + classApiClass.getResourceAsStream(filePath));

    }
}
