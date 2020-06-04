package com.liubingan;

import java.util.Arrays;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Rebuild_767 {
    public static void main(String[] args) {
        String str = "aab";
        reorganizeString(str);
    }

    public static String reorganizeString(String s) {
        int[] count = new int[26];
        int N = s.length();
        for (char ch : s.toCharArray()) {
            count[ch - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            count[i] += i;
        }
        Arrays.sort(count);
        int t = 1;
        char[] ans = new char[N];
        for (int i = 0; i < 26; i++) {
            int ct = count[i] / 100;
            char ch = (char) ('a' + (count[i]) % 100);
            if (ct > (N + 1) / 2) {
                return "";
            }
            for (int j = 0; j < ct; j++) {
                if (t >= N) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }
        return String.valueOf(ans);
    }

}
