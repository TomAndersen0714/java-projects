package libraries.java.lang;

/**
 * @author TomAndersen
 * @see java.lang.Class
 */
public class ClassAPI {
    public static void main(String[] args) {
        // Class.getClassLoader()
        System.out.println("ClassAPI.class.getClassLoader() = " + ClassAPI.class.getClassLoader());

        // isArray()
        // Determines if this Class object represents an array class.
        int[] nums = new int[]{1, 2, 3};
        System.out.println("nums.getClass().isArray() = " + nums.getClass().isArray());

        // getComponentType()
        System.out.println("nums.getClass().getComponentType() = " + nums.getClass().getComponentType());
    }
}
