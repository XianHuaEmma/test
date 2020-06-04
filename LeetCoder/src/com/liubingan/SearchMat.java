package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class SearchMat {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int right = matrix.length * matrix[0].length - 1;
        int left = 0;
        int mid;
        int ele;
        while (left <= right) {
            mid = (right + left) / 2;
            ele = matrix[mid / n][mid % n];
            if (ele == target) {
                return true;
            } else if (ele < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
