package com.xiao.knapsack;

import java.util.Scanner;

/**
 * 背包问题(01背包) hdu-2602:http://acm.hdu.edu.cn/showproblem.php?pid=2602
 * 
 * @author Lin LingXiao
 */
public class BoneCollector {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int q = scanner.nextInt();
            for (int i = 0; i < q; i++) {
                // n堆骨头
                int bonesNum = scanner.nextInt();
                // 袋子的容量
                int packVolume = scanner.nextInt();

                int[] valueArr = new int[bonesNum + 1];
                int[] volumeArr = new int[bonesNum + 1];

                // 体积
                for (int k = 1; k < volumeArr.length; k++) {
                    valueArr[k] = scanner.nextInt();
                }

                // 价值
                for (int k = 1; k < volumeArr.length; k++) {
                    volumeArr[k] = scanner.nextInt();
                }

                // 初始化背包数组
                int[] dp = new int[packVolume + 1];
                for (int j = 1; j <= bonesNum; j++) {
                    zeroOnePack(dp, valueArr[j], volumeArr[j]);
                }
                System.out.println(dp[packVolume]);
            }
        }
        scanner.close();
    }

    private static void zeroOnePack(int[] dp, int value, int volume) {
        // 从第一个物品开始
        for (int i = dp.length - 1; i >= volume; i--) {
            dp[i] = Math.max(dp[i], dp[i - volume] + value);
        }
    }
}
