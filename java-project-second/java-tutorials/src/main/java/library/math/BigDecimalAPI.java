package library.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalAPI {
    public static void main(String[] args) {
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

        // arithmetic operation methods will return a new object
        // and do not change the caller
        System.out.println(a);

        // compareTo
        System.out.println("a.compareTo(b) = " + a.compareTo(b));
    }
}
