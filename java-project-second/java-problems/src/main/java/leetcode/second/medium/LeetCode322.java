package leetcode.second.medium;

import leetcode.common.Util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 322. Coin Change, 硬币零钱匹配
 * https://leetcode.com/problems/coin-change/description
 *
 * @author TomAndersen
 */
public class LeetCode322 {
    public static void main(String[] args) {
        int[] coins;
        int amount, output;

        coins = Util.strToArray("[1,2,5]");
        amount = 11;
        output = 3;
        System.out.println(new LeetCode322_1().coinChange(coins, amount) == output);


        coins = Util.strToArray("[2]");
        amount = 3;
        output = -1;
        System.out.println(new LeetCode322_1().coinChange(coins, amount) == output);

        coins = Util.strToArray("[1]");
        amount = 0;
        output = 0;
        System.out.println(new LeetCode322_1().coinChange(coins, amount) == output);

        coins = Util.strToArray("[1,2,5]");
        amount = 11;
        output = 3;
        System.out.println(new LeetCode322_2().coinChange(coins, amount) == output);


        coins = Util.strToArray("[2]");
        amount = 3;
        output = -1;
        System.out.println(new LeetCode322_2().coinChange(coins, amount) == output);

        coins = Util.strToArray("[1]");
        amount = 0;
        output = 0;
        System.out.println(new LeetCode322_2().coinChange(coins, amount) == output);


        coins = Util.strToArray("[1,2,5]");
        amount = 11;
        output = 3;
        System.out.println(new LeetCode322_3().coinChange(coins, amount) == output);


        coins = Util.strToArray("[2]");
        amount = 3;
        output = -1;
        System.out.println(new LeetCode322_3().coinChange(coins, amount) == output);

        coins = Util.strToArray("[1]");
        amount = 0;
        output = 0;
        System.out.println(new LeetCode322_3().coinChange(coins, amount) == output);
    }
}

/**
 * Dynamic Programming + Recursion
 */
class LeetCode322_1 {
    public int coinChange(int[] coins, int amount) {
        // input
        if (coins == null || coins.length == 0) {
            return -1;
        }

        // transform
        // state transform equation, dp[i] = min{ dp[i-n] for n in array } + 1
        Map<Integer, Integer> dp = new LinkedHashMap<>();
        // initialize state array
        // dp.put(0, 0);

        // output
        return coinChange(coins, amount, dp);
    }

    // find minimum combinations, and put it into dp array
    private int coinChange(int[] coins, int amount, Map<Integer, Integer> dp) {
        // boundary situation
        if (amount == 0) {
            return 0;
        }

        // skip duplicate calculate
        if (dp.containsKey(amount)) {
            return dp.get(amount);
        }

        // calculate
        int minCombinations = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int rest = coinChange(coins, amount - coin, dp);
                if (rest >= 0) {
                    minCombinations = Math.min(minCombinations, rest + 1);
                }
            }
        }

        // change the default value of boundary
        if (minCombinations == Integer.MAX_VALUE) {
            minCombinations = -1;
        }
        dp.put(amount, minCombinations);
        return minCombinations;
    }
}

/**
 * Dynamic Programming + Array + Iteration
 * Why best?
 */
class LeetCode322_2 {
    public int coinChange(int[] coins, int amount) {
        // input
        if (coins == null || coins.length == 0) {
            return -1;
        }

        // transform
        int res = -1;
        // state transform equation, dp[i] = min{ dp[i-n] for n in coins }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);

        // initialize the state array
        dp[0] = 0;
        for (int rest = 1; rest <= amount; rest += 1) {
            for (int coin : coins) {
                if (coin <= rest && dp[rest - coin] < Integer.MAX_VALUE) {
                    dp[rest] = Math.min(dp[rest], dp[rest - coin] + 1);
                }
            }
        }

        // output
        res = dp[amount] == Integer.MAX_VALUE ? res : dp[amount];
        return res;
    }
}

/**
 * Dynamic Programming + Array + Recursive
 */
class LeetCode322_3 {
    public int coinChange(int[] coins, int amount) {
        // input
        if (coins == null || coins.length == 0) {
            return -1;
        }

        // transform
        // state transform equation, dp[i] = min{ dp[i-n] for n in array } + 1
        int[] dp = new int[amount + 1];
        // Arrays.sort(coins);

        // initialize state array
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // output
        return coinChange(coins, amount, dp);
    }

    // find minimum combinations, and put it into dp array
    private int coinChange(int[] coins, int amount, int[] dp) {
        // skip duplicate calculate
        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }

        // calculate
        int minCombinations = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (coin <= amount) {
                int restCombinations = coinChange(coins, amount - coin, dp);
                if (restCombinations >= 0) {
                    minCombinations = Math.min(minCombinations, restCombinations + 1);
                }
            }
        }

        // change the default value of boundary
        if (minCombinations == Integer.MAX_VALUE) {
            minCombinations = -1;
        }
        dp[amount] = minCombinations;
        return minCombinations;
    }
}
