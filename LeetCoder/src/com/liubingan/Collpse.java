package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Collpse {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int column = A[0].length;
        int[][] ans = new int[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
