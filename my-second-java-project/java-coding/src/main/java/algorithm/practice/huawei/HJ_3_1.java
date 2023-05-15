package algorithm.practice.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0
 * <p>
 * tags: string, array
 *
 * @author TomAndersen
 */
public class HJ_3_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // handle
        boolean[] exists = new boolean[501];
        for (int i = 0; i < n; i++) {
            exists[Integer.parseInt(br.readLine())] = true;
        }

        // output
        for (int i = 0; i < exists.length; i++) {
            if (exists[i]) {
                System.out.println(i);
            }
        }
    }
}
