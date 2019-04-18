package com.xiao.leetcode;

/**
 * @Title: https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * @Author: fanhy
 * @Date: 2019/4/17 21:07
 */
public class DivideTwoEqual {

    public static void main(String[] args) {
//        int[] arr = new int[]{
//                18, 40, 62, 33, 83, 64, 10, 92, 67, 31, 42, 51, 10, 97, 41, 7, 82, 71, 80, 81, 41, 38, 88, 25, 38, 89, 24, 89, 90, 12, 97, 21, 22, 85, 11, 59, 83, 6, 51, 47, 32, 82, 83, 100, 29, 78, 36, 32, 1, 31, 36, 19, 35, 3, 36, 21, 24, 93, 42, 33, 10, 26, 2, 39, 36, 62, 85, 24, 41, 5, 66, 53, 7, 1, 59, 53, 40, 59, 41, 95, 7, 67, 20, 29, 80, 59, 49, 49, 51, 90, 13, 52, 6, 90, 5, 6, 31, 81, 95, 26
//        };
        int[] arr = new int[]{1, 5, 11, 5};
        DivideTwoEqual e = new DivideTwoEqual();
        e.canPartition(arr);
    }

    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * 思路：要点在如何用任意个数凑出值为sum的一半。
     * 关键点在于枚举可能凑出的值
     * <p>
     * dp[i，j]代表前i个数的和是否是j,Vn代表第n个数的值
     * dp[i][j] = dp[i-1][j]||dp[i-1][j-Vn]; 如果前面 i-1个数能凑成j-Vn,那么前面i个数一定能凑成j
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int goal = sum / 2;

        boolean[] volume = new boolean[goal + 1];
        volume[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = goal; j >= nums[i]; j--) {
                volume[j] = volume[j] || volume[j - nums[i]];
            }
        }
        return volume[goal];
    }
}
