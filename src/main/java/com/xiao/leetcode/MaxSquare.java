package com.xiao.leetcode;

/**
 * https://leetcode-cn.com/problems/maximal-square/
 *
 * @Title:
 * @Author: fanhy
 * @Date: 2019/4/18 21:22
 */
public class MaxSquare {

    public static void main(String[] args) {
        MaxSquare e = new MaxSquare();
//        char[][] square = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] square = {{'0', '0'}, {'0', '0'}};
//        char[][] square = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
//        char[][] square = {{'1', '1', '0', '1',}, {'1', '1', '0', '1',}, {'1', '1', '1', '1',}};
//        char[][] square = {{'1', '1', '1', '1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '1', '1', '0'}, {'1', '1', '1', '1', '1', '0', '0', '0'}, {'0', '1', '1', '1', '1', '0', '0', '0'}};
//        char[][] square = {{'0', '0', '0', '1',}, {'1', '1', '0', '1',}, {'1', '1', '1', '1',}, {'0', '1', '1', '1',}, {'0', '1', '1', '1',}};
        char[][] square = {{'0', '0', '0', '1',}, {'1', '1', '1', '1',}, {'1', '1', '1', '1',}, {'1', '1', '1', '1',}, {'1', '1', '0', '0',}, {'1', '1', '1', '1',}, {'1', '1', '1', '0',}};

        int i = e.maximalSquare(square);
        System.out.println(i);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] square = new int[matrix.length + 1][matrix[0].length + 1];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int si = i + 1, sj = j + 1;
                if (matrix[i][j] == '0') {
                    continue;
                }
                int min = 0;
                for (int k = 1; k <= square[si - 1][sj - 1]; k++) {
                    if (matrix[i - k][j] == '0' || matrix[i][j - k] == '0') {
                        break;
                    }
                    min++;
                }
                square[si][sj] = Math.min(min, square[si - 1][sj - 1]) + 1;
                max = Math.max(square[si][sj], max);
            }
        }
        return max * max;
    }

}
