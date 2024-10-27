package pat.level1;

import java.util.Scanner;

// https://www.nowcoder.com/pat/6/problem/4077

/**
 * 简单方法, 直接依次读取, 判断, 输出.
 *
 * @author TomAndersen
 */
public class PAT_1001_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final long N = sc.nextLong();
        long a, b, c;


        for (int i = 1; i <= N; i++) {
            a = sc.nextLong();
            b = sc.nextLong();
            c = sc.nextLong();
            if (a + b > c) {
                System.out.println("Case #" + i + ": " + "true");
            }
            else {
                System.out.println("Case #" + i + ": " + "false");
            }
        }
    }
}
