package com.second;

import java.util.PriorityQueue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class LastStoneTwo {
    public static void main(String[] args) {
        LastStoneTwo last = new LastStoneTwo();
        int []stone=new int[]{2,4,3,1,8,1};
        System.out.println(last.lastStoneWeight(stone));
    }
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((w1, w2) -> w1 == w2 ? w1 - w2 : w2.compareTo(w1));
        for (int i : stones) {
            heap.offer(i);
        }
        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (x < y) {
                heap.offer(y - x);
            }
        }
        if(heap.size()>0){
            return heap.poll();
        }
        return 0;
    }
}
