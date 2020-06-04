package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class FaguanTwo {
    public int findJudge(int N, int[][] trust) {
        int[] cur = new int[N];
        for (int[] arr : trust) {
            cur[arr[0]]--;
            cur[arr[1]]++;
        }
        for (int i : cur) {
            if (cur[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
