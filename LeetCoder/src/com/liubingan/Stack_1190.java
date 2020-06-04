package com.liubingan;

import java.util.Stack;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Stack_1190 {
    public static void main(String[] args) {
        String test = "(u(love)i)";
        String test2 = "(bcdefghijkl(mno)p)";
        System.out.println(reverseParentheses(test2));
    }

    public static String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String temp = sb.toString();
                for (int j = 0; j < temp.length(); j++) {
                    stack.add(temp.charAt(j));
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}
