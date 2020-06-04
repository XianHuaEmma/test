package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class searchMatri_25 {
    public static void main(String[] args) {

        int [][]matrix ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        spiralOrder(matrix);
    }
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[0];
        }
        int R = matrix.length;
        int C = matrix[0].length;
        int n = R*C;
        int []ans = new int[n];
        int count = 0;
        int row = 0;
        int col = 0;
        int i = 0;
        while(count<n){
            i++;
            while(col<C&&count<n){
                ans[count]=matrix[row][col];
                col++;
                count++;
            }
            row++;
            col--;
            while(row<R&&count<n){
                ans[count]=matrix[row][col];
                row++;
                count++;
            }
            col--;
            row--;
            while(col>=i-1&count<n){
                ans[count]=matrix[row][col];
                col--;
                count++;
            }
            col++;
            row--;
            while(row>=i&&count<n){
                ans[count]=matrix[row][col];
                row--;
                count++;
            }
            row++;
            R = R-1;
            C = C-1;
            col++;

        }
        return ans;
    }
}
