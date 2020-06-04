package com.liubingan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Stack_225 {
    Queue<Integer> storage;
    Queue<Integer> mainQueue;
    int top;

    public Stack_225() {

        mainQueue = new LinkedList<>();
        storage = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        top = x;
        mainQueue.add(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while(mainQueue.size()>1){
            int temp = mainQueue.remove();
            storage.add(temp);
        }
        int last = mainQueue.remove();
        Queue<Integer>tempQueue = mainQueue;
        mainQueue =storage;
        storage = tempQueue;
        return last;


    }

    /**
     * Get the top element.
     */
    public int top() {
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}
