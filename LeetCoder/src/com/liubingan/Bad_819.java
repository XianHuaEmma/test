package com.liubingan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Bad_819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bandset = new ArrayList<>();
        for (String band : banned) {
            bandset.add(band);
        }
        Map<String, Integer> countMap = new HashMap<>();
        int count = 0;
        StringBuilder word = new StringBuilder();
        String ans = "";
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));

            } else if (word.toString().length() > 0) {
                String wordStr = word.toString();
                if (!bandset.contains(wordStr)) {
                    countMap.put(wordStr, countMap.getOrDefault(wordStr, 0) + 1);
                    if (countMap.get(wordStr) > count) {
                        ans = wordStr;
                        count = countMap.get(wordStr);
                    }
                }
                word = new StringBuilder();
            }
        }
        return ans;
    }
}
