package com.second;

/**
 * @Author：liubingan
 * @date: 91
 * @描述：
 */
public class BianMa {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        char[] nums = s.toCharArray();
        int n = s.length();
        int dp[] = new int[n + 1]; //i到n的编码个数
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == '0') continue;//以0开头表示可以跳过该状态
            int num = 0;
            for (int j = i; j < n && j - i < 2; j++) {
                num = 10 * num + nums[j] - '0';
                if (num <= 26) {
                    dp[i] += dp[j + 1];
                }
            }
        }
        return dp[0];
    }
}
