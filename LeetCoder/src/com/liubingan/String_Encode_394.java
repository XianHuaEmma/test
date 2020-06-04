package com.liubingan;

import java.util.Stack;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class String_Encode_394 {
    public static void main(String[] args) {
        System.out.println(decodeString("2[abc]3[cd]ef"));
    }


    public static String decodeString(String s) {
        char[]ch = s.toCharArray();
        Stack<String>stack = new Stack<>();
        for(char temp:ch){
            if(temp==']'){
                StringBuilder ans = new StringBuilder();
                while(!"[".equals(stack.peek())){
                    ans.append(stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty()&&Character.isDigit(stack.peek().charAt(0))){
                    num.append(stack.pop());
                }
                int n = Integer.parseInt(num.reverse().toString());
                String str = generateString(n,ans.toString());
                stack.push(str);
            }else{
                stack.push(temp+"");
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.empty()){
            res.append(stack.pop());
        }


        return res.reverse().toString();
    }

    private static String generateString(int n,String str){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(str);
        }
        return res.toString();
    }
}
