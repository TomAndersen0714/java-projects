package hw;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1
 * <p>
 * tags: string, ASCII
 *
 * @author TomAndersen
 */
public class HJ_2 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray = br.readLine().toCharArray();
        char ch = br.readLine().charAt(0);

        // handle
        int count = 0;
        char lo = Character.toLowerCase(ch), hi = Character.toUpperCase(ch);
        for (char c : charArray) {
            if (c == lo || c == hi) {
                count++;
            }
        }

        // output
        System.out.println(count);
    }
}
