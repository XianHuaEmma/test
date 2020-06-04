package com.liubingan;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Stone_1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
                (w1, w2) -> w2 - w1
        );
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int y = heap.poll();
            int x = heap.poll();
            if (x != y) {
                int dif = y - x;
                heap.offer(dif);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }

    public int lastStoneWeight2(int[] stones) {
        int weight = 0;
        int len = stones.length;
        for (int i = 0; i < stones.length; i++) {
            Arrays.sort(stones);
            int y = stones[len - 1];
            int x = stones[len - 2];
            weight = y - x;
            stones[len - 1] = weight;
            stones[len - 2] = 0;
        }
        return stones[len - 1];
    }
}
