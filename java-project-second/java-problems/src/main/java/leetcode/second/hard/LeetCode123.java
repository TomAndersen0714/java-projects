package leetcode.second.hard;

import leetcode.common.Util;

import java.util.Arrays;

/**
 * 123. Best Time to Buy and Sell Stock III, 股票买卖3
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class LeetCode123 {
    public static void main(String[] args) {
        int[] prices;
        int output;

        prices = Util.strToArray("[3,3,5,0,0,3,1,4]");
        output = 6;
        System.out.println(new LeetCode123_1().maxProfit(prices) == output);

        prices = Util.strToArray("[1,2,3,4,5]");
        output = 4;
        System.out.println(new LeetCode123_1().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode123_1().maxProfit(prices) == output);

        prices = Util.strToArray("[3,3,5,0,0,3,1,4]");
        output = 6;
        System.out.println(new LeetCode123_2().maxProfit(prices) == output);

        prices = Util.strToArray("[1,2,3,4,5]");
        output = 4;
        System.out.println(new LeetCode123_2().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode123_2().maxProfit(prices) == output);

        prices = Util.strToArray("[3,3,5,0,0,3,1,4]");
        output = 6;
        System.out.println(new LeetCode123_3().maxProfit(prices) == output);

        prices = Util.strToArray("[1,2,3,4,5]");
        output = 4;
        System.out.println(new LeetCode123_3().maxProfit(prices) == output);

        prices = Util.strToArray("[7,6,4,3,1]");
        output = 0;
        System.out.println(new LeetCode123_3().maxProfit(prices) == output);
    }
}

/**
 * Divide + Greedy
 * Time limit exceeded.
 */
class LeetCode123_1 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        for (int i = 0; i < prices.length; i += 1) {
            dp[i] = maxProfitOneTrade(prices, 0, i) + maxProfitOneTrade(prices, i, prices.length - 1);
            maxProfit = Math.max(maxProfit, dp[i]);
        }

        // output
        return maxProfit;
    }

    private int maxProfitOneTrade(int[] prices, int start, int end) {
        if (start == end) {
            return 0;
        }

        int minPrice = prices[start], maxProfit = 0;
        for (int i = start; i <= end; i += 1) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxProfit;
    }
}

/**
 * Dynamic Programming
 */
class LeetCode123_2 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // transform
        // state array,
        int maxProfit = 0;
        // state transform equation
        // dp[i][0] 无操作的最大利润, dp[i][1] 已买一次的最大利润, dp[i][2] 已买卖一次的最大利润, dp[i][3] 已买一次卖一次买一次的最大利润, dp[i][4] 已买卖两次的最大利润
        // 第i天, dp[i][0] = 0, dp[i][1] = max {dp[i-1][1], price[i]}, dp[i][2] = max{dp[i-1][2], price[i] + dp[i][1]}, dp[i][3] = max{dp[i-1][3], dp[i-1][2]-price[i]}, dp[i][4] = max{dp[i-1][4],dp[i-1][3]+price[i]}
        int[] dp = new int[5];
        dp[1] = -prices[0];
        dp[2] = 0;
        dp[3] = -prices[0];
        dp[4] = 0;

        // initialize state array
        // iterate and fill state array
        for (int i = 1; i < prices.length; i++) {
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        // output
        maxProfit = dp[4];
        return maxProfit;
    }
}

/**
 * Dynamic Programming
 */
class LeetCode123_3 {
    public int maxProfit(int[] prices) {
        // input
        if (prices == null || prices.length == 0) {
            return 0;
        }

        // transform
        // state equation
        int maxProfit = 0;
        // yes[0] 代表第1次交易后持有股票时的最大利润, yes[1]代表第2次交易后持有, no[0]代表第1次交易后未持有股票的最大利润, no[1]代表第2次交易后未持有
        int[] yes = new int[]{0, 0}, no = new int[]{0, 0};
        Arrays.fill(yes, -prices[0]);

        for (int price : prices) {
            // 先更新未持有, 再更新持有
            no[1] = Math.max(no[1], yes[1] + price);
            yes[1] = Math.max(yes[1], no[0] - price);
            no[0] = Math.max(no[0], yes[0] + price);
            yes[0] = Math.max(yes[0], -price);
        }

        // output
        maxProfit = no[1];
        return maxProfit;
    }
}
