package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] tempArr = transpose(arr);
        int rowlen = tempArr.length;
        int collen = tempArr[0].length;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                System.out.print(tempArr[i][j] + " ");
            }
        }
    }

    private static int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
}
