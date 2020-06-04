package com.liubingan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class CommonWord {
    public static void main(String[] args) {
        String str="Bob hit a ball, the hit BALL flew far after it was hit.";
        String []band={"hit"};
        System.out.println(mostCommonWord(str,band));
    }

    private static String mostCommonWord(String paragraph, String[] banned) {
        // " |\\!|\\?|'|,|;|\\."如下正则表达式也可以
        List<String> list = Arrays.stream(paragraph.toLowerCase().split("[\\p{Punct}\\s]+")).collect(Collectors.toList());
        List<String> bandList = Arrays.stream(banned).map(String::toLowerCase).collect(Collectors.toList());
        Map<String, Integer> map = new HashMap<>();
        String key = "";
        int max = 0;
        for (String temp : list) {
            if (!bandList.contains(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                if (map.get(temp) > max) {
                    key = temp;
                    max = map.get(temp);
                }
            }
        }
        return key;
    }
}
