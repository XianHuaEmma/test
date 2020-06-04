package com.second;

/**
 * @Author：liubingan
 * @date: 122
 * @描述：
 */
public class GuPiao {
    public int maxProfit(int[] prices) {
        int vally = 0;
        int peak = 0;
        int maxProfix = 0;
        int i = 0;
        int n = prices.length;
        while (i < n - 1) {
            while (i < n - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            vally = prices[i];
            while (i < n - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxProfix += peak - vally;

        }
        return maxProfix;
    }
}
