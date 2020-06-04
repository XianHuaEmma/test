package com.bag;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class LongestReStr {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbccbbd"));
    }

    public static String longestPalindrome(String s) {
        int strlen = s.length();
        String result = "";
        for (int i = 0; i < strlen; i++) {
            String temp = s.substring(0, i+1);
            String sub = getLongest(temp);
            if (result.length() < sub.length()) {
                result = sub;
            }
        }
        return result;
    }

    private static String getLongest(String str) {
        int len = str.length();
        if(len==0){
            return "";
        }
        for (int i = 0; i < len; i++) {
            String temp = str.substring(i);
            int templen = temp.length();
            if (templen == 1) {
                return temp;
            }
            int mid = templen / 2;
            if (templen % 2 == 0) {
                if (temp.substring(0, mid).equals(new StringBuilder(temp.substring(mid)).reverse().toString())) {
                    return temp;
                }
            } else {
                if (temp.substring(0, mid).equals(new StringBuilder(temp.substring(mid+1)).reverse().toString())) {
                    return temp;
                }
            }

        }
        return "";
    }
}
