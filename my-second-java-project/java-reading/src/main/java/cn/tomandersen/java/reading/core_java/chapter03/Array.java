package cn.tomandersen.java.reading.core_java.chapter03;

import java.util.Arrays;

public class Array {
    static void initiateArray() {
        // array declaration
        int[] a; // Java style
        int b[]; // C style

        // array without any element
        a = new int[]{};
        System.out.println(a);
        System.out.println(a.toString()); // 数组无法直接打印, 必须遍历每个元素才能打印
        a = new int[0];
        System.out.println(a);
        System.out.println(a.toString());

        // initialization
        int[] x = new int[20]; // initialize with length
        int[] y = {1, 2, 3, 4, 5}; // initialize with assignment
        int[] z = new int[]{1, 2, 3, 4, 5}; // initialize with assignment
        int[][] xy = { // double dimension array
                {1, 2, 3},
                {4, 5},
                {6, 7}
        };
        System.out.println("y: " + y.toString()); // toString can not return the real value of element
        System.out.println("z: " + Arrays.toString(z));
        System.out.println("y == z: " + (y == z));// y != z
        System.out.println(Arrays.toString(xy)); // Arrays.toString only support one dimension array
        System.out.println();

        int[] q = {1, 2, 3, 4, 5};
        int[] w = new int[]{1, 2, 3, 4, 5};
        System.out.println("q == y: " + (q == y));// q != y, i.e. 数组没有常量传播, 每次赋值都是创建一个新对象
        System.out.println("w != z: " + (w != z));// w != z
    }

    static void accessArray() {
        int[] a = new int[100];
        // 对于数值类型的数组(integer/float), 其元素默认值都是0, 或0.0
        // 对于布尔类型的数组(boolean), 其元素默认值都是false
        // 对于对象类型的数组(object), 其元素的默认值都是null

        // print the array using for-each
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();

        // print the array using Arrays
        System.out.println(Arrays.toString(a));

        // initiate array
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i == a.length - 1) continue;
            System.out.print(',');
        }
        System.out.println();
    }

    static void copyArray() {
        int[] a = {1, 2, 3, 4};
        int[] b;

        // copy the reference of array
        b = a;
        System.out.println("a == b: " + (a == b));

        // deep copy the elements of array
        b = Arrays.copyOf(a, a.length);
        System.out.println("a == b: " + (a == b));
        System.out.println(Arrays.toString(b));

    }

    static void commandLineArgs(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        initiateArray();
//        accessArray();
//        copyArray();
//        commandLineArgs(args);
    }
}
