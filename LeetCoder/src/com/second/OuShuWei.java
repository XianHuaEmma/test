package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class OuShuWei {
    public static void main(String[] args) {
        OuShuWei odd = new OuShuWei();
        System.out.println(odd.countOdd(1, 1000));
    }

    public int countOdd(int n, int m) {
        int len1 = String.valueOf(n).length();
        int len2 = String.valueOf(m).length();
        int start = n;
        int all = m - n + 1;
        if (len1 == len2 && len1 % 2 == 0) {
            return all;
        } else if (len1 == len2 && len1 % 2 != 0) {
            return 0;
        }
        int dff = 0;
        int end = 0;
        for (int i = len1; i <= len2; i++) {
            end = toTen(i);
            if (i == len2) {
                end = m+1;
            }
            if (i % 2 != 0) {
                dff += (end - start);
            }
            start = end;
        }

        return all - dff;
    }

    private int toTen(int len) {
        int res = 1;
        while (len > 0) {
            res *= 10;
            len--;
        }
        return res;
    }
}
