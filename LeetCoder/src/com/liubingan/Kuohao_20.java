package com.liubingan;

import java.util.Stack;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Kuohao_20 {
    public boolean isValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char temp : ch) {
            if (temp == '{' || temp == '[' || temp == '(') {
                stack.push(temp);
            } else if (temp == '}' && stack.peek() == '{') {
                stack.pop();
            } else if (temp == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (temp == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }
}
