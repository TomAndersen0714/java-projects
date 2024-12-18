package lesson2.data_structure;

import java.util.Arrays;

public class Array {
    static void initiateArray() {
        System.out.println("initiateArray(): ");
        // declare
        int[] a; // Java-style
        int[][] aa;
        int b[]; // C-style

        // empty array
        a = new int[]{};
        System.out.println(a);
        System.out.println(a.toString()); // 数组无法直接打印, 必须遍历每个元素才能打印

        a = new int[4]; // 构造数组时必须声明其空间大小
        System.out.println(a);
        System.out.println("a =" + a.toString());
        aa = new int[8][]; // 构造数组时必须声明其空间大小
        System.out.println(aa);
        System.out.println("aa =" + Arrays.deepToString(aa));

        // NOTE: initiate array using literal
        // 1. initialize with specific length
        int[] x = new int[20];
        int[] y = {1, 2, 3, 4, 5};
        // 2. initialize with assignment
        int[] z = new int[]{1, 2, 3, 4, 5};
        int[][] xx = { // double dimension array
            {1, 2, 3}, {4, 5}, {6, 7}
        };

        String[] names = {"b", "c"};
        String[][] xys = {{"a", "b"}, {"b", "c"}};
        System.out.println("names = " + Arrays.toString(names));
        System.out.println("xys = " + Arrays.deepToString(xys));

        xx = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        System.out.println("y: " + y.toString()); // toString can not return the real value of element
        System.out.println("z: " + Arrays.toString(z));
        System.out.println("y == z: " + (y == z));// y != z
        System.out.println(Arrays.toString(xx)); // Arrays.toString only support one dimension array
        System.out.println();

        int[] q = {1, 2, 3, 4, 5};
        int[] w = new int[]{1, 2, 3, 4, 5};
        System.out.println("q == y: " + (q == y));// q != y, i.e. 数组没有常量传播, 每次赋值都是创建一个新对象
        System.out.println("w != z: " + (w != z));// w != z

        int m = 0, n = 1;
        x = new int[]{m, n};
        System.out.println("Arrays.toString(x) = " + Arrays.toString(x));

        // initiate array using for statement
        a = new int[20];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i == a.length - 1) continue;
            System.out.print(',');
        }
        System.out.println();

        // initiate array using Arrays.fill()
        Arrays.fill(a, 1);
        System.out.println(Arrays.toString(a));

        // initiate array using Arrays.setAll()
        Arrays.setAll(a, (i) -> i + 1);
        System.out.println(Arrays.toString(a));
    }

    static void traverseArray() {
        System.out.println("traverseArray(): ");
        int[] a = new int[100];
        // 对于数值类型的数组(integer/float), 其元素默认值都是0, 或0.0
        // 对于布尔类型的数组(boolean), 其元素默认值都是false
        // 对于对象类型的数组(object), 其元素的默认值都是null

        // print the array using for-each
        for (int num : a) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    static void cloneArray() {
        System.out.println("cloneArray(): ");
        int[] a = {1, 2, 3, 4};
        int[] b;

        // copy the reference of array
        System.out.println();
        System.out.println("Copy the reference of array: ");
        b = a;
        System.out.println("a == b: " + (a == b));

        // deep copy the elements of array
        System.out.println();
        System.out.println("Deep copy of array: ");
        // 1. Arrays.copyOf()
        System.out.println("1. Arrays.copyOf(): ");
        b = Arrays.copyOf(a, a.length);
        System.out.println("a == b: " + (a == b));
        System.out.println(Arrays.toString(b));

        // 2. clone()
        System.out.println("2. Array.clone(): ");
        b = a.clone();
        System.out.println("a == b: " + (a == b));
        System.out.println(Arrays.toString(b));

    }

    static void printArray(String[] args) {
        System.out.println(Arrays.toString(args));
    }

    static void arrayFromIntToInteger() {
        System.out.println("arrayFromIntToInteger(): ");
        // initiate array using Arrays.setAll
        int[] nums = new int[20];
        Arrays.setAll(nums, (i) -> (i + 1));

        // convert array from int[] type into Integer[] type
        System.out.println("convert array from int[] type into Integer[] type: ");
        // 1. using for statement
        System.out.println("1. using for statement: ");
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        System.out.println(Arrays.toString(integers));

        // 2. using Arrays.setAll() and auto boxing
        System.out.println("2. using Arrays.setAll() and auto boxing: ");
        Integer[] integers1 = new Integer[nums.length];
        Arrays.setAll(integers1, (i) -> (nums[i]));
        System.out.println(Arrays.toString(integers1));

        // 3. using streaming programming and functional interface
        System.out.println("3. using functional interface: ");
        // the method reference 'Integer[]::new' is equivalent to the lambda expression 'x->new Integer(x)'
        Integer[] integers2 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers2));

    }

    // todo, how to convert int array to Integer array?
    // todo, how to convert string array to Integer array?
    static void arrayFromStringToInteger() {
        // 1. convert string array to Integer array by stream
        String[] strings = new String[]{"111", "222"};
        System.out.println(
            Arrays.toString(
                Arrays.stream(strings).mapToInt(Integer::parseInt).toArray()
            )
        );
    }

    public static void main(String[] args) {
        initiateArray();
        // printArray(args);
        // traverseArray();
        // cloneArray();
        // arrayFromIntToInteger();
    }
}
