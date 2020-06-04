package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class CircleArray {
    public int maxSubarraySumCircular(int[] A) {
        int ans1 = 0;
        int cur1=0;
        int ans2 = 0;
        int cur2=0;
        int max = Integer.MIN_VALUE;
        int sum=0;
        int []B=new int[A.length];
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max,A[i]);
            B[i]=-1*A[i];
            cur1=A[i]+ Math.max(cur1,0);
            cur2=B[i]+ Math.max(cur2,0);
            ans1= Math.max(cur1,ans1);
            ans2= Math.max(cur2,ans2);
            sum +=A[i];
        }
        if(max<0){
            return max;
        }
        return Math.max(sum+ans2,ans1);
    }
}
