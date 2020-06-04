package com.second;

import java.awt.image.RasterOp;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MyCircularQueue {
    private int capacity;
    private int headIndex;
    private int roarIndex;
    private int[] arr;
    private int count;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.arr = new int[k];
        this.headIndex = 0;
        this.roarIndex = 0;
        this.count = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (capacity == count) {
            return false;
        } else {
            roarIndex = (headIndex + count) % capacity;
            arr[roarIndex] = value;
        }
        count++;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        arr[headIndex] = 0;
        headIndex++;
        headIndex %= capacity;
        count--;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return arr[headIndex];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return arr[roarIndex];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        if (count == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        if (count == capacity) {
            return true;
        }
        return false;
    }
}
