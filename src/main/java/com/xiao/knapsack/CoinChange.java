package com.xiao.knapsack;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/submissions/
 *
 * @Title: 完全背包问题
 * @Author: fanhy
 * @Date: 2019/4/17 23:35
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int amount = 11;
        CoinChange e = new CoinChange();
        System.out.println(e.coinChange(arr, amount));

    }

    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE / 2;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }

}
