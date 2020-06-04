package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Bucket_1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        for (int num : arr1) {
            bucket[num]++;
        }
        int[] res = new int[arr1.length]; //因为对arr1排序，因此可以用arr1代替res，可以减少内存
        int i = 0;
        for (int num : arr2) {
            while (bucket[num] > 0) {
                res[i] = num;
                i++;
                bucket[num]--;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (bucket[j] > 0) {
                res[i] = j;
                i++;
                bucket[j]--;
            }
        }
        return res;
    }
}
