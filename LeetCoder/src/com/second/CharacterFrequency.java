package com.second;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class CharacterFrequency {
    public static void main(String[] args) {
        String str = "raaeaecere";
        CharacterFrequency ch = new CharacterFrequency();
        System.out.println(ch.frequencySort(str));
    }
    public  String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>((w1, w2) -> map.get(w1) .equals(map.get(w2))  ?
                w1.compareTo(w2) : map.get(w2) - map.get(w1)
        );
        heap.addAll(map.keySet());

        StringBuilder ans = new StringBuilder();

        while (!heap.isEmpty()) {
            char temp = heap.poll();
                ans.append(concat(temp,map.get(temp)));

        }
        return ans.toString();
    }
    private String concat(char c,int n){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append(String.valueOf(c));
        }
        return res.toString();
    }
}
