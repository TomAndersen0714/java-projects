package leetcode.second.easy;

import leetcode.common.Util;

/**
 * 121. Best Time to Buy and Sell Stock, 股票买卖1
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
 */
public class LeetCode121 {
    public static void main(String[] args) {
        int[] prices;
        int output;

        prices = Util.strToArray("[7,1,5,3,6,4]");
        output = 5;
        System.out.println(new LeetCode121_1().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode121_1().maxProfit(prices) == output);

        prices = Util.strToArray("[7,1,5,3,6,4]");
        output = 5;
        System.out.println(new LeetCode121_2().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode121_2().maxProfit(prices) == output);
    }
}

/**
 * Dynamic Programming
 */
class LeetCode121_1 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        int res = 0;
        // dp array, dp[i] means the max profit when sell the stock on day-i
        // state transform equation, dp[i] = max { dp[j] + prices[i]-prices[j] for j<i if prices[j] < prices[i] }
        int[] dp = new int[prices.length];
        // initialize the dp array
        dp[0] = 0;

        // iteration and fill the dp array
        for (int i = 1; i < prices.length; i += 1) {
            for (int j = 0; j < i; j += 1) {
                if (prices[j] < prices[i]) {
                    dp[i] = Math.max(prices[i] - prices[j] + dp[j], dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        // output
        return res;
    }
}

/**
 * Greedy + Iteration
 */
class LeetCode121_2 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        int maxProfitCur = 0, minPriceCur = prices[0];
        for (int price : prices) {
            maxProfitCur = Math.max(price - minPriceCur, maxProfitCur);
            minPriceCur = Math.min(price, minPriceCur);
        }

        // output
        return maxProfitCur;
    }
}
