package com.liubingan;

import java.util.Arrays;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class LongestPrefix {
    public static void main(String[] args) {
        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }

    private static String longestCommonPrefix(String[] strs) {
//        int min = Arrays.stream(strs).min((o1, o2) -> o1.length() < o2.length() ? -1 : 1).get().length();
        int min = Integer.MAX_VALUE;
        for (String str : strs) min = Math.min(min, str.length());
        String common = "";
        for (int i = min - 1; i >= 0; i--) {
            String pre = strs[0].substring(0, i + 1);
            boolean flag = true;
            for (String temp : strs) {
                if (!temp.startsWith(pre)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                common = pre;
                break;
            }

        }
        return common;
    }
}
