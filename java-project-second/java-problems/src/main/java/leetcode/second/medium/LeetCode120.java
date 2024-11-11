package leetcode.second.medium;

import leetcode.common.Util;

import java.util.List;

/**
 * 120. Triangle, 三角形自顶向下最短路径
 * https://leetcode.com/problems/triangle/description/
 *
 * @author TomAndersen
 */
public class LeetCode120 {
    public static void main(String[] args) {
        List<List<Integer>> input;
        int output;

        input = Util.strToListList("[[-10]]");
        output = -10;
        System.out.println(new LeetCode120_1().minimumTotal(input) == output);

        input = Util.strToListList("[[2],[3,4],[6,5,7],[4,1,8,3]]");
        output = 11;
        System.out.println(new LeetCode120_1().minimumTotal(input) == output);
    }
}

/**
 * Dynamic Process
 */
class LeetCode120_1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // input
        if (triangle == null || triangle.size() <= 0) {
            return 0;
        }

        // transform
        int minPath = 0;
        // state transfer equation
        // dp[i][j] = min{dp[i+1][j], dp[i+1][j+1]} + triangle[i][j]
        int height = triangle.size();
        int width = triangle.get(height - 1).size();
        int[][] dp = new int[height][width];

        // init state array
        for (int j = 0; j < width; j++) {
            dp[height - 1][j] = triangle.get(height - 1).get(j);
        }

        // iterate the dp array from bottom to top
        for (int i = height - 2; i >= 0; i -= 1) {
            int w = triangle.get(i).size();
            for (int j = 0; j < w; j += 1) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        // output
        minPath = dp[0][0];
        return minPath;
    }
}
