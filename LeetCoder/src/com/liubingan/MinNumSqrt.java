package com.liubingan;

import java.util.Arrays;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class MinNumSqrt {
    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }

    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int j = 1;
            while (i - j * j >= 0) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                j++;
            }
        }
        return dp[n];
    }

}
