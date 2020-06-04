package com.second;

import java.util.Stack;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KuoHaoReverse {
    public static void main(String[] args) {
        String str = "a(bcdefghijkl(mno)p)q";
        String str2 = "(u(love)i)";
        System.out.println(reverseParentheses(str));
    }

    public static String reverseParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("(")) {
                    temp.append(stack.pop());
                }
                stack.pop();
                if (stack.contains("(")) {
                    stack.push(temp.reverse().toString());

                } else {
                    stack.push(temp.toString());
                }

            } else {
                stack.push(c + "");
            }
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < stack.size() ; i++) {
            ans.append(stack.get(i));
        }

        return ans.toString();
    }
}
