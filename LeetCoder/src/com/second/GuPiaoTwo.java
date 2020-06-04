package com.second;

/**
 * @Author：liubingan
 * @date: 122
 * @描述：
 */
public class GuPiaoTwo {
    public int cal(int[] prices) {
        int profix = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profix += prices[i] - prices[i - 1];
            }
        }
        return profix;
    }
}
