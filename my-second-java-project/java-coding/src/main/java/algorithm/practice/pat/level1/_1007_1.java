package algorithm.practice.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// https://www.nowcoder.com/pat/6/problem/4043

/**
 * @author TomAndersen
 */
public class _1007_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        String numbers = inputs[0];
        int divisor = Integer.parseInt(inputs[1]);

        // divide, and store the quotient by iteration
        int reminder = 0;
        int[] quotients = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            int number = numbers.charAt(i) - '0';
            quotients[i] = (reminder * 10 + number) / divisor;
            reminder = (reminder * 10 + number) % divisor;
        }

        // concat, and print
        StringBuilder res = new StringBuilder();
        if (quotients[0] != 0) {
            res.append(quotients[0]);
        }
        for (int i = 1; i < quotients.length; i++) {
            res.append(quotients[i]);
        }

        res.append(" ");
        res.append(reminder);
        System.out.println(res);
    }
}
