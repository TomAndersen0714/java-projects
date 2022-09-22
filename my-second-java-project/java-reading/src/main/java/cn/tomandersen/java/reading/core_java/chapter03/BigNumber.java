package cn.tomandersen.java.reading.core_java.chapter03;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigNumber {
    static void bigIntegerDemo() {
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

    static void bigDecimalDemo() {
        // BigDecimal, for high precision float-point calculation
        System.out.println("This is a bitDecimal Demo: ");
        BigDecimal a = BigDecimal.valueOf(0.1d + 0.2d);
        System.out.println(a);

        a = new BigDecimal("0.31");
        System.out.println(a);

        // arithmetic operations
        BigDecimal b = BigDecimal.valueOf(3);
        System.out.println(a.add(b)); // add
        System.out.println(a.subtract(b)); // subtract
        System.out.println(a.multiply(b)); // multiply
//        System.out.println(a.divide(b)); // divide, 如果返回值是无限小数, 则会抛出异常
        System.out.println(a.divide(b, RoundingMode.CEILING)); // divide, with cell round mode, 即向上取整
        System.out.println(a.divide(b, RoundingMode.HALF_UP)); // divide, with half up round mode, 即四舍五入

        // arithmetic operation methods will return a new object and not change the caller
        System.out.println(a);
    }


    public static void main(String[] args) {
        bigIntegerDemo();
        bigDecimalDemo();
    }
}
