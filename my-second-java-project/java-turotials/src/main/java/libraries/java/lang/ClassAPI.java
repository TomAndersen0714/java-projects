package libraries.java.lang;

/**
 * @author TomAndersen
 * @see java.lang.Class
 */
public class ClassAPI {
    public static void main(String[] args) throws ClassNotFoundException {
        // note: class method

        // Class.forName()
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("className = " + className);
        Class<?> clazz = Class.forName(className);
        System.out.println("(clazz == ClassAPI.class) = " + (clazz == ClassAPI.class));


        // note: instance method

        // Class.getClassLoader()
        System.out.println("ClassAPI.class.getClassLoader() = " + ClassAPI.class.getClassLoader());

        // getName()
        System.out.println("ClassAPI.class.getName() = " + ClassAPI.class.getName());
        // getSimpleName()
        System.out.println("ClassAPI.class.getSimpleName() = " + ClassAPI.class.getSimpleName());


        // isArray()
        // Determines if this Class object represents an array class.
        int[] nums = new int[]{1, 2, 3};
        Class<? extends int[]> numsClass = nums.getClass();
        System.out.println("numsClass.isArray() = " + numsClass.isArray());
        // getComponentType()
        System.out.println("numsClass.getComponentType() = " + numsClass.getComponentType());

        // getResource()
        // !!!
        String filePath = "/test.txt";
        Class<ClassAPI> classAPIClass = ClassAPI.class;
        System.out.println("classAPIClass.getResource(\"/\").getPath() = " + classAPIClass.getResource(filePath).getPath());
        System.out.println("classAPIClass.getResource(filePath) = " + classAPIClass.getResource(filePath));
        // getResourceAsStream()
        System.out.println("classAPIClass.getResourceAsStream(filePath) = " + classAPIClass.getResourceAsStream(filePath));

    }
}
