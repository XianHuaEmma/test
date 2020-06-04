package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class ZeroAndOne {
    public static void main(String[] args) {
        int[]w=new int[]{1,2,3};
        int []v=new int[]{6,10,12};
        System.out.println(sum(5,w,v));
    }
    private static int sum(int C,int[]w,int []v){
        int[][]dp = new int[v.length][C+1];
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < C+1; j++) {
                if(w[i]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i-1]]+v[i]);
                }
            }

        }
        return dp[v.length-1][C];

    }
}
