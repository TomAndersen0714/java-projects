package libraries.java.lang.reflect;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author TomAndersen
 * @see java.lang.reflect.Array
 */
public class ArrayAPI {
    public static void main(String[] args) {
        // NOTE: class method
        // Array.newInstance()
        int[] nums = (int[]) Array.newInstance(int[].class.getComponentType(), 4);
        Arrays.fill(nums, 12);
        System.out.println(Arrays.toString(nums));
    }
}
