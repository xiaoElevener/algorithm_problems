package com.xiao.leetcode;

import java.util.Arrays;

/**
 * @Title:
 * @Author: fanhy
 * @Date: 2019/4/17 23:09
 */
public class Rob2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        Rob2 e = new Rob2();
        System.out.println(e.rob(arr));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int length = nums.length;
        return Math.max(maxValue(Arrays.copyOfRange(nums, 0, length - 1)), maxValue(Arrays.copyOfRange(nums, 1, length)));
    }

    public int maxValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
