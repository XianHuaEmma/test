package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KuoHaoYouXiaoTanXin {
    public boolean checkValidString(String s) {
        int min = 0; //min左括号的最小数，max右括号的最大值
        int max = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++;
                max++;
            } else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                if (max-- == 0) {
                    return false;
                }
            } else {
                if (min > 0) {
                    min--;
                }
                max++;
            }

        }
        return min == 0;
    }
}
