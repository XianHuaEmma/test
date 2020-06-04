package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class SumCircular {
    public static void main(String[] args) {
        int[]arr = new int[]{3,-1,2,-1};
        System.out.println(maxSubarraySumCircular(arr));
    }

    private static int maxSubarraySumCircular(int[] A) {
        int max = 0;
        int len = A.length;
        boolean flag = true;
        for (int i = 0; i < 2 * len; i++) {
            if (A[i % len] + max > max && flag) {
                max += A[i % len];
            } else if (A[i % len] >= max) {
                max = A[i % len];
                flag = true;
            } else {
                flag = false;
            }
        }
        return max;
    }
}
