package algorithm.practice.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.nowcoder.com/practice/196534628ca6490ebce2e336b47b3607
 *
 * @author TomAndersen
 */
public class HJ_6 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        // handle
        StringBuilder sb = new StringBuilder();
        int quotient = num;
        for (int i = 2; i <= Math.sqrt(quotient); i++) {
            while ((i <= Math.sqrt(quotient)) && (quotient % i == 0)) {
                sb.append(i).append(' ');
                quotient = quotient / i;
            }
        }
        sb.append(quotient);

        // output
        System.out.println(sb);
    }

}
