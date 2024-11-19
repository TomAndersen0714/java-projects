package hw.first;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6
 *
 * @author TomAndersen
 */
public class HJ_5 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String hexStr = br.readLine().toUpperCase().replaceFirst("0X", "");

        // handle
        int value = Integer.valueOf(hexStr, 16);

        // output
        System.out.println(value);
    }
}
