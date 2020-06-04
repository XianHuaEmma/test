package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class SearchMat_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int C = col - 1;
        int R = 0;
        while (R < row && C >= 0) {
            if (target == matrix[R][C]) {
                return true;
            } else if (target < matrix[R][C]) {
                C--;
            } else {
                R++;
            }
        }
        return false;
    }
}
