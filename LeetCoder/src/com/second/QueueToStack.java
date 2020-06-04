package com.second;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class QueueToStack {
    Deque<Integer>deque;
    public QueueToStack(){
        deque = new ArrayDeque<>();
    }
    public void push(int x) {
       deque.addFirst(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pollFirst();
    }

    /** Get the top element. */
    public int top() {
        return deque.peekFirst();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
