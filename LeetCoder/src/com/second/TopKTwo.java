package com.second;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class TopKTwo {
    public static void main(String[] args) {
        String[] arr = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(arr, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>
                ((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                        w1.compareTo(w2) : map.get(w2) - map.get(w1)
                ); //针对map具有排序的特性
        heap.addAll(map.keySet());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(heap.poll());
        }
        return ans;
    }
}
