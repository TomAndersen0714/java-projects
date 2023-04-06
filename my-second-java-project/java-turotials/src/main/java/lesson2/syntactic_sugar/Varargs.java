package lesson2.syntactic_sugar;

import libraries.Utils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
 *
 * @author TomAndersen
 */
public class Varargs {
    public static void main(String[] args) {
        // NOTE: varargs is a kind of syntactic sugar, that pass multiple arguments into an array.
        //  Since JDK 5.
        Object[] arguments = {7, new Date(), "a disturbance in the Force"};

        String result = MessageFormat.format("At {1,time} on {1,date}, there was {2} on planet " + "{0}.", arguments);
        System.out.println("result = " + result);

        variableArgsDemo(1, 2, 3, 4, 5);
    }

    /**
     * the signature of the method equals to 'static void variableArgsDemo(int[] nums)'
     */
    static void variableArgsDemo(int... nums) {
        System.out.println("variableArgsDemo: ");
        System.out.println("nums.getClass().isArray() = " + nums.getClass().isArray());

        System.out.println("Utils.getClassName(new int[]{1, 2, 3}) = " + Utils.getClassName(new int[]{1, 2, 3}));
        System.out.println("Utils.getClassName(nums) = " + Utils.getClassName(nums));
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
    }
}
