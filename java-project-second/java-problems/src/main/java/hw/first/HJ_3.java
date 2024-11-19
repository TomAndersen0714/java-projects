package hw.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0
 * <p>
 * tags: string, array
 *
 * @author TomAndersen
 */
public class HJ_3 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // handle
        Set<Integer> nums = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.valueOf(br.readLine()));
        }

        // output
        for (int num : nums) {
            System.out.println(num);
        }

    }
}
