package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Tribo_1137 {

    private int[] rem = new int[38];

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 | n == 2) {
            return 1;
        }
        if (rem[n] != 0) {
            return rem[n];
        }
        rem[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return rem[n];
    }
}
