package ccf_csp;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * http://118.190.20.162/view.page?gpid=T128
 *
 * @author TomAndersen
 */

public class _20210401 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int l = Integer.parseInt(inputs[2]);

        // traverse
        int[] counts = new int[l];
        for (int i = 0; i < n; i++) {
            inputs = bf.readLine().split(" ");
            for (String input : inputs) {
                int idx = Integer.parseInt(input);
                counts[idx] += 1;
            }
        }

        // output
        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}
