package com.liubingan;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Word_692 {
    public static void main(String[] args) {
        String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        topKFrequent(arr, k);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String temp : words) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        List<String> list = new ArrayList(map.keySet());
        // 升序排列
        Collections.sort(list, (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return list.subList(0, k);
    }

    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String temp : words) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        //降序排列
        PriorityQueue<String> heap = new PriorityQueue<String>((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));
        for (String temp : map.keySet()) {
            heap.offer(temp);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }
}
