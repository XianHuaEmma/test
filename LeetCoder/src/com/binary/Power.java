package com.binary;

/**
 * @Author：liubingan
 *
 * @date: 2019
 * @描述：
 */
public class Power {
    public static void main(String[] args) {

    }

    /**
     * 如果 n 为偶数，我们可以用公式 (x ^ n) ^ 2 = x ^ {2 * n}(xn2=x2∗n
     * 来得到 x ^ n = A * Ax
     * n=A∗A。如果 n 为奇数，那么 A * A = x ^ {n - 1}A∗A=x
     * n−1
     * @param x
     * @param n
     * @return
     */
    private static double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2); //x^2n = x^n*x^n   x^2+1 = x^n*x^n*x
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

}
