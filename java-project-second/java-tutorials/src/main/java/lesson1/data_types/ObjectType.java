package lesson1.data_types;

import library.Utils;

import java.util.Arrays;

/**
 * @author TomAndersen
 */
public class ObjectType {
    public static void main(String[] args) {
        // NOTE: In Java, all variables except for primitive types are of the Object type.

        // Array
        int[] intArray = new int[]{1, 2, 3};
        System.out.println("Utils.getClassName(intArray) = " + Utils.getClassName(intArray));

        // Array initializer
        int[] array = {-1, 0, 1, 2, -1, -4};
        // 数组字面量只能在声明变量的语句中使用
        // array = {1, 2, 3};
        System.out.println("array.toString() = " + Arrays.toString(array));
        System.out.println("Utils.getClassName(array) = " + Utils.getClassName(array));

        long[] longArray = new long[]{1, 2, 3};
        System.out.println("Utils.getClassName(longArray) = " + Utils.getClassName(longArray));


    }
}
