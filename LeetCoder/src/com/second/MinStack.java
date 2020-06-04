package com.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MinStack {
    int min;
    List<Integer> stack;
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new ArrayList<>();

    }

    public void push(int x) {
        if(x<min){
            min = x;
        }
        stack.add(x);

    }

    public void pop() {
        int ans = stack.remove(stack.size()-1);
        if(min==ans){
            min = Integer.MAX_VALUE;
            for(int i:stack){
                if(i<min){
                    min = i;
                }
            }

        }


    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
