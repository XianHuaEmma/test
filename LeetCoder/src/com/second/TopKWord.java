package com.second;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class TopKWord {
    public static void main(String[] args) {
        String []arr = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(topKFrequent(arr,k));
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                w1.compareTo(w2) : count.get(w2) - count.get(w1)); //升序

        return candidates.subList(0, k);
    }
}
