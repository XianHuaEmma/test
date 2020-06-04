package com.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class FenShu {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            ans.append("-");
        }
        long remain = Math.abs(Long.valueOf(numerator));
        long deno = Math.abs(Long.valueOf(denominator));
        ans.append(String.valueOf(remain / deno));
        if (remain % deno == 0) {
            return ans.toString();
        }
        Map<Long, Integer> map = new HashMap<>(); // 出现相同的余数，说明有循环
        remain = remain % deno;
        while (remain != 0) {
            if (map.containsKey(remain)) {
                ans.insert(map.get(remain), "(").append(")").toString();
                break;
            }
            map.put(remain, ans.toString().length());
            remain *= 10;
            ans.append(String.valueOf(remain / deno));
            remain %= deno;
        }
        return ans.toString();
    }
}
