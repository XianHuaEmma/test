package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class TongPaiXv {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] buget = new int[1001];
        for (int num : arr1) {
            buget[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (buget[num] != 0) {
                arr1[i] = num;
                buget[num]--;
                i++;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (buget[j] != 0) {
                arr1[i] = j;
                i++;
            }
        }
        return arr1;
    }
}
