package leetcode.second.medium;

import leetcode.common.Util;

/**
 * 122. Best Time to Buy and Sell Stock II, 股票买卖2
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description
 */
public class LeetCode122 {
    public static void main(String[] args) {
        int[] prices;
        int output;

        prices = Util.strToArray("[7,1,5,3,6,4]");
        output = 7;
        System.out.println(new LeetCode122_1().maxProfit(prices) == output);

        prices = Util.strToArray("[1,2,3,4,5]");
        output = 4;
        System.out.println(new LeetCode122_1().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode122_1().maxProfit(prices) == output);


        prices = Util.strToArray("[7,1,5,3,6,4]");
        output = 7;
        System.out.println(new LeetCode122_2().maxProfit(prices) == output);

        prices = Util.strToArray("[1,2,3,4,5]");
        output = 4;
        System.out.println(new LeetCode122_2().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode122_2().maxProfit(prices) == output);
    }
}

/**
 * Greedy + Iteration
 * 既然需要利润最大值，且不限制买卖次数，那么所有可能的正向收益，理论上我都能拿到
 */
class LeetCode122_1 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        int maxProfit = 0;
        int previousPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > previousPrice) {
                maxProfit += prices[i] - previousPrice;
            }
            previousPrice = prices[i];
        }

        // output
        return maxProfit;
    }
}

/**
 * Dynamic Programming
 */
class LeetCode122_2 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        // state array, dp[i][0] 代表第i天中手里没有股票时的最大收益, dp[i][1] 代表第i天中手里有股票时的最大收益
        // state transform equation, dp[i][0] = max {dp[i-1][0], dp[i-1][1] + prices[i]}, dp[i-1][1] = max {dp[i-1][0] - price[i-1], dp[i-1][1]}
        int[][] dp = new int[prices.length][2];
        // initialize the state array
        dp[0] = new int[]{0, -prices[0]};

        for (int i = 1; i < dp.length; i += 1) {
            dp[i] = new int[]{0, 0};
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // output
        int res = Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
        return res;
    }
}
