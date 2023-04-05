package libraries.java.lang;

/**
 * @author TomAndersen
 * @see java.lang.Class
 */
public class ClassAPI {
    public static void main(String[] args) throws ClassNotFoundException {
        // note: class method

        // Class.forName
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("className = " + className);
        Class<?> clazz = Class.forName(className);
        System.out.println("(clazz == ClassAPI.class) = " + (clazz == ClassAPI.class));

        // Class.getClassLoader()
        System.out.println("ClassAPI.class.getClassLoader() = " + ClassAPI.class.getClassLoader());


        // note: instance method

        // isArray()
        // Determines if this Class object represents an array class.
        int[] nums = new int[]{1, 2, 3};
        System.out.println("nums.getClass().isArray() = " + nums.getClass().isArray());

        // getComponentType()
        System.out.println("nums.getClass().getComponentType() = " + nums.getClass().getComponentType());


    }

    public static void getClassObjDemo() throws ClassNotFoundException {
        // method 1: Class object, using class name explicitly
        System.out.println("ClassAPI.class = " + ClassAPI.class);

        // method 2: class method Class.forName(), using class name as a parameter
        String className = Thread.currentThread().getStackTrace()[1].getClassName();
        System.out.println("Class.forName(className) = " + Class.forName(className));

        // method 3: instance method getClass() of corresponding class
        Object obj = new Object();
        System.out.println("obj.getClass() = " + obj.getClass());
    }
}
