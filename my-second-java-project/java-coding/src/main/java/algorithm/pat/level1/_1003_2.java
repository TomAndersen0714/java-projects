package algorithm.pat.level1;


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author TomAndersen
 */
public class _1003_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");

        short m = Short.parseShort(inputs[0]);
        short n = Short.parseShort(inputs[1]);
        long num = 1;
        short cnt = 0;

        // skip the first m-1 prime numbers
        while (cnt < m - 1) {
            num += 1;
            if (isPrime(num)) {
                cnt += 1;
            }
        }
        // cnt == m-1

        // search the leaf n-m+1 prime numbers, and append into the string
        StringBuilder sb = new StringBuilder();
        while (cnt < n) {
            num += 1;
            if (isPrime(num)) {
                cnt += 1;
                sb.append(num);
                if ((cnt - m + 1) % 10 == 0) sb.append('\n');
                else if (cnt < n) sb.append(' ');
                // avoid space in the end of the last line
            }
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
