package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class LonggestPrefix {
    public static void main(String[] args) {
        String[]arr={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(arr));

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }


}
