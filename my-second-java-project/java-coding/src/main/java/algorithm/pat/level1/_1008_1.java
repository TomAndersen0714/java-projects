package algorithm.pat.level1;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
// https://www.nowcoder.com/pat/6/problem/4044

/**
 * @author TomAndersen
 */
public class _1008_1 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        // input and count
        int[] resCountX = new int[3];
        int[] resCountY = new int[3];

        int[] bcjCountX = new int[3];
        int[] bcjCountY = new int[3];

        for (int i = 0; i < n; i++) {
            String input = bf.readLine();
            switch (input) {
                case "C C":
                    break;
                case "C J":
                    break;
                case "C B":
                    break;
                case "J C":
                    break;
                case "J J":
                    break;
                case "J B":
                    break;
                case "B C":
                    break;
                case "B J":
                    break;
                case "B B":
                    break;
                default:
                    break;
            }


        }

        // print
    }
}
