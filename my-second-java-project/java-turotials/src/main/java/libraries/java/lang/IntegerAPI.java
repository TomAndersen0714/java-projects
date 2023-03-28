package libraries.java.lang;

/**
 * @author TomAndersen
 * @see java.lang.Integer
 */
public class IntegerAPI {
    /**
     * @param args
     * @see libraries.java.lang.NumberAPI
     */
    public static void main(String[] args) {
        // note: instance method

        // constructor(deprecated since jdk9)
        Integer num1 = new Integer(12);
        // constructor(auto boxing by compiler)
        Integer num2 = 12;


        // note: class constant
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);

        // note: class method


    }
}
