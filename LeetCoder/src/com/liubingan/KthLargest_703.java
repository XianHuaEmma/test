package com.liubingan;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KthLargest_703 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        int k = 3;
        KthLargest kth = new KthLargest(k, arr);
        System.out.println(kth.add(3));
        System.out.println(kth.add(5));
    }

}

class KthLargest {

    int size;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        size = k;
        heap = new PriorityQueue<>(

        );
        for (int num : nums) {
            heap.offer(num);
        }
        while(heap.size()>k){
            heap.poll();
        }

    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.add(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
}