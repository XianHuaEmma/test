package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Longest_14 {

    public static void main(String[] args) {
        String []words={"baab","bacb","b","cbc"};
        System.out.println(longestCommonPrefix(words));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        }
        int mid = (left + right) / 2;
        String leftString = longestCommonPrefix(strs, left, mid);
        String rightString = longestCommonPrefix(strs, mid + 1, right);
        return getPrefix(leftString, rightString);
    }

    static String getPrefix(String lword, String rword) {
        String res = lword;
        while (rword.indexOf(res) != 0) {
            res = res.substring(0, res.length() - 1);
            if (res.length() == 0) {
                return "";
            }
        }
        return res;
    }
}
