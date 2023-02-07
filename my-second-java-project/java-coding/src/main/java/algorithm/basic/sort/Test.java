package algorithm.basic.sort;

import utils.Utils;

import java.util.Arrays;
import java.util.Objects;

// https://blog.csdn.net/weixin_43207025/article/details/114902065

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            int[] a = Utils.randomArrayInt(5, 50);
            int[] b = Arrays.copyOf(Objects.requireNonNull(a), a.length);
            System.out.println(Arrays.toString(a));

            // test
            ShellSort1.sort(a);
            Arrays.sort(b);
            System.out.println(Arrays.toString(b));

            if (!Arrays.equals(a, b)) {
                System.out.println(Arrays.toString(a));
                System.out.println("Error");
                break;
            }
        }
    }
}
