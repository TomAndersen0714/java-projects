package lesson1.data_types;

import libraries.Utils;

/**
 * @author TomAndersen
 */
public class ObjectDataType {
    public static void main(String[] args) {
        // NOTE: In Java, all variables except for primitive types are of the Object type.

        // Array
        int[] intArray = new int[]{1, 2, 3};
        System.out.println("Utils.getClassName(intArray) = " + Utils.getClassName(intArray));


        long[] longArray = new long[]{1, 2, 3};
        System.out.println("Utils.getClassName(longArray) = " + Utils.getClassName(longArray));


    }
}
