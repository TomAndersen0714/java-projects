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
        // NOTE: instance method

        // constructor(deprecated since jdk9)
        Integer num1 = new Integer(12);
        // constructor(auto boxing by compiler)
        Integer num2 = 12;


        // NOTE: class constant
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("1000000*1000000 < Integer.MIN_VALUE = " + (1000000 * 1000000 < Integer.MIN_VALUE));


        // NOTE: class method
        // Integer.toString(int i, int radix)
        // Returns a string representation of the first argument in the radix specified by the second argument
        System.out.println("Integer.toString(12, 8) = " + Integer.toString(12, 8));
        System.out.println("Integer.toString(13, 4) = " + Integer.toString(13, 4));

        // Integer.toBinaryString(int i)
        System.out.println("Integer.toBinaryString(13) = " + Integer.toBinaryString(13));
        // Integer.toHexString(int i)
        System.out.println("Integer.toHexString(30) = " + Integer.toHexString(30));
        // Integer.toOctalString(int i)
        System.out.println("Integer.toOctalString(12) = " + Integer.toOctalString(12));
        // Integer.toUnsignedString(int i)
        System.out.println("Integer.toUnsignedString(-12) = " + Integer.toUnsignedString(-12));


        // Integer.valueOf(String s)
        System.out.println("Integer.valueOf(\"123\") = " + Integer.valueOf("123"));
        // Integer.valueOf(String s, int radix)
        // convert an integer from radix n to radix 10
        System.out.println("Integer.valueOf(\"123\", 8) = " + Integer.valueOf("123", 8));
        // convert an integer from radix 10 to radix n
        System.out.println("Integer.toString(123,8) = " + Integer.toString(123, 8));


        // Integer.numberOfLeadingZeros(int i)
        System.out.println("Integer.numberOfLeadingZeros(123) = " + Integer.numberOfLeadingZeros(123));
        // Integer.numberOfTrailingZeros(int i)
        System.out.println("Integer.numberOfTrailingZeros(123) = " + Integer.numberOfTrailingZeros(123));
        // Integer.bitCount(int i)
        System.out.println("Integer.bitCount(123) = " + Integer.bitCount(123));


        // Integer.min(int a, int b)
        System.out.println("Integer.min(12,23) = " + Integer.min(12, 23));
        // Integer.max(int a, int b)
        System.out.println("Integer.max(1,2) = " + Integer.max(1, 2));


        // Integer.lowestOneBit(int i)
        System.out.println("Integer.toBinaryString(123) = " + Integer.toBinaryString(123));
        System.out.println("Integer.lowestOneBit(123) = " + Integer.lowestOneBit(123));
        // Integer.highestOneBit(int i)
        System.out.println("Integer.toBinaryString(Integer.highestOneBit(123)) = " + Integer.toBinaryString(Integer.highestOneBit(123)));
    }
}
