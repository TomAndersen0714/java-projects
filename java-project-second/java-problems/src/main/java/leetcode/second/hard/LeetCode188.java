package leetcode.second.hard;

import leetcode.common.Util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 188. Best Time to Buy and Sell Stock IV, 股票买卖4
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description
 */
public class LeetCode188 {
    public static void main(String[] args) {
        int[] prices;
        int k, output;

        prices = Util.strToArray("[2,4,1]");
        k = 2;
        output = 2;
        System.out.println(new LeetCode188_1().maxProfit(k, prices) == output);

        prices = Util.strToArray("[3,2,6,5,0,3]");
        k = 2;
        output = 7;
        System.out.println(new LeetCode188_1().maxProfit(k, prices) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode188_1 {
    public int maxProfit(int k, int[] prices) {
        // input
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }

        // transform
        int maxProfit = 0;

        // state array, yes[i][j] 代表第i天进行第j笔交易的买入操作后持有股票时的最大利润, no[i][j] 代表第i天已经进行过第j笔交易的卖出后未持有股票的最大利润, 注意: 同一笔交易的卖出在买入之后, 因此前者依赖后者, 后者要先计算
        // state transform equation, yes[i][j] = max{yes[i-1][j], no[i-1][j-1] - price}, no[i][j] = max{no[i-1][j],yes[i-1][j]+price}

        int[][] yes = new int[prices.length][k + 1];
        int[][] no = new int[prices.length][k + 1];

        // initialize dp array, 第0天的所有买入, 利润都为 -prices[0]; 第0次交易，即无交易，利润默认为0
        Arrays.fill(yes[0], 1, k + 1, -prices[0]);

        // iterate and fill dp array
        for (int i = 1; i < prices.length; i += 1) {
            int price = prices[i];

            for (int j = 1; j <= k; j += 1) {
                yes[i][j] = Math.max(yes[i - 1][j], no[i - 1][j - 1] - price);
                no[i][j] = Math.max(no[i - 1][j], yes[i - 1][j] + price);
            }
            maxProfit = Math.max(maxProfit, no[i][k]);
        }

        // output
        return maxProfit;
    }
}
