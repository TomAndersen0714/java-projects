package libraries.java.lang;

/**
 * @author TomAndersen
 * @see java.lang.Integer
 */
public class IntegerAPI {
    public static void main(String[] args) {
        // note: instance method
        // constructor(deprecated since jdk9)
        Integer num = new Integer(12);

        // constructor(auto boxing)
        num = 12;
    }
}
