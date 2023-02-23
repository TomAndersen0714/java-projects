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
                case "C J":
                    resCountX[0] += 1;
                    resCountY[2] += 1;
                    bcjCountX[1] += 1;
                    break;
                case "C B":
                    resCountX[2] += 1;
                    resCountY[0] += 1;
                    bcjCountY[0] += 1;
                    break;
                case "J C":
                    resCountX[2] += 1;
                    resCountY[0] += 1;
                    bcjCountY[1] += 1;
                    break;
                case "J B":
                    resCountX[0] += 1;
                    resCountY[2] += 1;
                    bcjCountX[2] += 1;
                    break;
                case "B C":
                    resCountX[0] += 1;
                    resCountY[2] += 1;
                    bcjCountX[0] += 1;
                    break;
                case "B J":
                    resCountX[2] += 1;
                    resCountY[0] += 1;
                    bcjCountY[2] += 1;
                    break;
                default:
                    resCountX[1] += 1;
                    resCountY[1] += 1;
                    break;
            }
        }

        // print
        StringBuilder sb = new StringBuilder();
        sb.append(resCountX[0]);
        sb.append(' ');
        sb.append(resCountX[1]);
        sb.append(' ');
        sb.append(resCountX[2]);
        sb.append('\n');
        sb.append(resCountY[0]);
        sb.append(' ');
        sb.append(resCountY[1]);
        sb.append(' ');
        sb.append(resCountY[2]);
        sb.append('\n');

        if (bcjCountX[0] >= bcjCountX[1] && bcjCountX[0] >= bcjCountX[2]) sb.append("B");
        else if (bcjCountX[1] > bcjCountX[0] && bcjCountX[1] >= bcjCountX[2]) sb.append("C");
        else sb.append("J");
        sb.append(" ");
        if (bcjCountY[0] >= bcjCountY[1] && bcjCountY[0] >= bcjCountY[2]) sb.append("B");
        else if (bcjCountY[1] > bcjCountY[0] && bcjCountY[1] >= bcjCountY[2]) sb.append("C");
        else sb.append("J");

        System.out.println(sb);
    }
}
