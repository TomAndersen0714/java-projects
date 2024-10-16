package library.math;

import java.math.BigInteger;

public class BigIntegerAPI {
    public static void main(String[] args) {
        // BigInteger, for high precision integer calculation
        System.out.println("This is a bigInteger Demo: ");
        BigInteger a = BigInteger.valueOf(1_000_000_000); // valueOf only support long type
        System.out.println(a);
        a = new BigInteger("1000000000");
        System.out.println(a);

        // constant variable
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.TWO);
        System.out.println(BigInteger.TEN);

        // arithmetic operations
        BigInteger b = BigInteger.valueOf(3);
        System.out.println(a.add(b)); // add
        System.out.println(a.subtract(b)); // subtract
        System.out.println(a.multiply(b)); // multiply
        System.out.println(a.divide(b)); // divide
        System.out.println(a.mod(b));
        System.out.println(a.sqrt());

        // compare
        System.out.println(a.compareTo(b));

        // arithmetic operation methods will return a new object and not change the caller
        System.out.println(a);
    }
}
