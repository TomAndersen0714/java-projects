package pat.level1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// https://www.nowcoder.com/pat/6/problem/4079

/**
 * @author TomAndersen
 */
public class PAT_1003_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        short m = Short.parseShort(inputs[0]);
        short n = Short.parseShort(inputs[1]);

        short cnt = 0;
        long num = 1;
        long[] nums = new long[n - m + 1];

        // skip the first m-1 prime numbers in the head
        while (cnt < m - 1) {
            num += 1;

            if (isPrime(num)) {
                cnt += 1;
            }
        }

        // get the prime numbers
        while (cnt < n) {
            num += 1;

            if (isPrime(num)) {
                cnt += 1;
                nums[cnt - m] = num;
            }
        }

        // print the found prime numbers by batch
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if ((i + 1) % 10 == 0) sb.append('\n');
            else if (i < nums.length - 1) sb.append(' ');
        }
        System.out.print(sb);
    }

    private static boolean isPrime(long num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}
