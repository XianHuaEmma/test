package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Reverse_557 {
    public String reverseWords(String s) {
        String[]arr=s.split(" ");
        StringBuilder ans = new StringBuilder();
        for(String temp:arr){
            StringBuilder reverse = new StringBuilder(temp);
            ans.append(reverse.reverse()).append(" ");
        }
        return ans.toString().trim();
    }
}
