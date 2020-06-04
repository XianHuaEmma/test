package com.second;

import java.util.PriorityQueue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KthLargest {
    PriorityQueue<Integer> heap;
    int size;

    public KthLargest(int k, int[] nums) {
        size = k;
        heap = new PriorityQueue<>((w1, w2) -> w1 == w2 ? w2 - w1 : w1.compareTo(w2)); // 建立小根堆
        for (int i : nums) {
            if (heap.size() < k) {
                heap.offer(i);
            } else if (heap.peek() < i) {
                heap.poll();
                heap.offer(i);
            }
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}
