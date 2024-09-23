package hw;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://www.nowcoder.com/practice/d9162298cb5a437aad722fccccaae8a7
 * <br>
 *
 * @author TomAndersen
 */
public class HJ_4 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // handle
        StringBuilder sb = new StringBuilder();
        int i = 0, len = input.length();
        while (i < len) {
            for (int j = 0; j < 8; j++) {
                if (i < len) {
                    sb.append(input.charAt(i));
                    i += 1;
                }
                else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }

        // output
        System.out.print(sb);
    }
}
