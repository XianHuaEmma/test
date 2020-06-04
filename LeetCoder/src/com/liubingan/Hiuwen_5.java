package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Hiuwen_5 {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        int len = s.length();
        char[] ch = s.toCharArray();
        boolean dp[][] = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            dp[i][i + 1] = (ch[i] == ch[i + 1]);
        }
        int max = 1;
        int left = 0;
        int right = 0;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (i + 1 != j) {
                    dp[i][j] = dp[i + 1][j - 1] && ch[i] == ch[j];
                }
                if (dp[i][j] && max < j - i + 1) {
                    max = j - i + 1;
                    right = j;
                    left = i;
                }
            }
        }
        return s.substring(left, right + 1);
    }

}
