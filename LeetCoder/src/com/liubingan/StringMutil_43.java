package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class StringMutil_43 {
    public static void main(String[] args) {
        System.out.println(multiply("0","0"));
    }

    public static String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int l = l1+l2;
        int[]ans = new int[l];
        char[]ch1=num1.toCharArray();
        char[]ch2=num2.toCharArray();
        for(int i=l1-1;i>=0;i--){
            int n1 = ch1[i]-'0';
            for(int j = l2-1;j>=0;j--){
                int n2 = ch2[j]-'0';
                ans[i+j+1]+=n1*n2;
            }
        }
        for(int i=l-1;i>0;i--){
            if(ans[i]>9){
                ans[i-1] =ans[i-1]+ ans[i]/10;
                ans[i] %= 10;
            }
        }
        int k=0;
        for(;k<l;k++){
            if(ans[k]!=0){
                break;
            }
        }
        if(k==l){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for(int i=k;i<l;i++){
            res.append((char) (ans[i] + '0'));
        }
        return res.toString();

    }
}
