package algorithm.practice.ccf_csp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http://118.190.20.162/view.page?gpid=T127
 *
 * @author TomAndersen
 */
public class _20210402_1 {
    /**
     * https://blog.csdn.net/weixin_49070253/article/details/123168339
     * 基于输入矩阵, 构建其前缀和矩阵, 避免重复计算
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = bf.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int l = Integer.parseInt(inputs[1]);
        int r = Integer.parseInt(inputs[2]);
        int t = Integer.parseInt(inputs[3]);

        int[][] grayArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            inputs = bf.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                grayArray[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        // traverse
        int count = 0;
        for (int i = 0; i < grayArray.length; i++) {
            for (int j = 0; j < grayArray[i].length; j++) {
                // if (adjacentGrayAvg(grayArray, i, j, r) <= t) {
                //     count += 1;
                // }
            }
        }

        // output
        System.out.println(count);
    }

}
