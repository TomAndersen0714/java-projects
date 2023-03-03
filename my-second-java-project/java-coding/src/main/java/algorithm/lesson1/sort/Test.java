package algorithm.lesson1.sort;

import utils.Utils;

import java.util.Arrays;
import java.util.Objects;

// https://blog.csdn.net/weixin_43207025/article/details/114902065

/**
 * @author TomAndersen
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            int[] a = Utils.randomArrayInt(3, 50);
            int[] b = Arrays.copyOf(Objects.requireNonNull(a), a.length);
            System.out.println(Arrays.toString(a));

            // test
            Arrays.sort(a);
            System.out.println(Arrays.toString(a));

            HeapSort1_1.sort(b);
            if (!Arrays.equals(a, b)) {
                System.out.println(Arrays.toString(b));
                System.out.println("Error");
                break;
            }
        }
    }
}
