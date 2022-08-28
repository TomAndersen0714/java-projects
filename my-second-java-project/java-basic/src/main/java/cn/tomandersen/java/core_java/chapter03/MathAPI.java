package cn.tomandersen.java.core_java.chapter03;

/**
 * {@link java.lang.Math}
 */
public class MathAPI {
    public static void main(String[] args) {
        // Math package
        double x = 4.0, y = 4.1;
        System.out.println("sqrt: " + Math.sqrt(x)); // sqrt
        System.out.println("pow: " + Math.pow(x, 4)); // power

        System.out.println("round: " + Math.round(y)); // round
        System.out.println("floor: " + Math.floor(y)); // floor
        System.out.println("ceil: " + Math.ceil(y)); // ceil
        System.out.println("random[0.0, 1.0): " + Math.random()); // random, return a random number in [0.0, 1.0)
        System.out.println("random[0.0, 5.0): " + Math.random() * 5); // random, return a random number in [0.0, 5.0)


        long position = 5;
        long adjustment = 3;
        System.out.println(Math.floorMod(position + adjustment, 12)); // floorMod
        adjustment = -10;
        System.out.println(Math.floorMod(position + adjustment, 12));

        // trigonometric function
        System.out.println(Math.PI);
        System.out.println(Math.E);

        double radian = Math.PI / 6.0; // a angle in radian, Pi * radian = 180 * degrees
        System.out.println(Math.sin(radian));
        System.out.println(Math.cos(radian));
        System.out.println(Math.tan(radian));

        // safe arithmetic calculate to avoid overflow
//        System.out.println(Math.multiplyExact(1_000_000_000, 3)); // java.lang.ArithmeticException: integer overflow
        System.out.println(Math.addExact(1_000_000_000, 3));
        System.out.println(Math.subtractExact(1_000_000_000, 3));
        System.out.println(Math.incrementExact(1_000_000_000));
    }
}
