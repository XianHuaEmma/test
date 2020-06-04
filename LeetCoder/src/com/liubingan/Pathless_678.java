package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Pathless_678 {
    public boolean checkValidString(String s) {
        int llow = 0; //左括号的最小值
        int lhih = 0;// 左括号的最大值
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                llow++;
                lhih++;
            } else if (s.charAt(i) == ')') {
                if (llow > 0) {
                    llow--;
                }
                if (lhih > 0) {
                    lhih--;
                } else {
                    return false;
                }
            } else {
                if (llow > 0) {
                    llow--;
                }
                lhih++;
            }
        }
        return llow <= 0 && 0 <= lhih;
    }
}
