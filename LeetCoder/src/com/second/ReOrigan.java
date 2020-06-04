package com.second;

import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class ReOrigan {
    public static void main(String[] args) {
        ReOrigan re = new ReOrigan();
        String str = "vvvlo";
        System.out.println(re.reorganizeString(str));
    }

    public String reorganizeString(String S) {
        int[] count = new int[26];
        int N = S.length();
        for (char c : S.toCharArray()) {
            count[c - 'a'] += 100;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                count[i] += i;
            }
        }
        Arrays.sort(count);
        char[] ans = new char[N];
        int index = 0;
        for (int i = 25; i >= 0; i--) {
            int n = count[i] / 100;
            char ch = (char) ('a' + count[i] % 100);
            if (n > (N + 1) / 2) {
                return "";
            }
            while (n > 0) {
                if (index >= N) {
                    index = 1;
                }
                ans[index] = ch;
                index += 2;
                n--;
            }
        }
        return String.valueOf(ans);

    }
}
