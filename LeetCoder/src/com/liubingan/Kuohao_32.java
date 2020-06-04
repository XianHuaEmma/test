package com.liubingan;

import java.util.Stack;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Kuohao_32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
    public static int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] ch = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        for(char temp:ch){
            if(temp=='('){
                stack.push(temp);
            } else if(temp==')'&&!stack.isEmpty()&&stack.peek()==')'){
                ans.append(stack.pop()).append(temp);
            } else{
                stack.push(temp);
            }
        }
        return ans.toString().length();
    }
}
