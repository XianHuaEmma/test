package com.liubingan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MinStack_155 {
    int min;
    List<Integer> list;

    public MinStack_155() {
        min = Integer.MAX_VALUE;
        list = new ArrayList<>();
    }

    public void push(int x) {
        if (x < min) {
            min = x;
        }
        list.add(x);
    }

    public void pop() {
        int value = list.remove(list.size() - 1);
        if (value == min) {
            min = Integer.MAX_VALUE;
            for (int temp : list) {
                if (temp < min) {
                    min = temp;
                }
            }
        }
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        return min;
    }
}
