package com.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class MostComonWord {
    public static void main(String[] args) {
        String[] ban = new String[0];
        System.out.println(mostCommonWord("Bob",ban));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        StringBuilder temp = new StringBuilder();
        List<String>list = Arrays.asList(banned);
        Map<String,Integer> map=new HashMap<>();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                temp.append(Character.toLowerCase(c));
            } else if(temp.toString().length() > 0){
                if(!list.contains(temp.toString())){
                    map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+1);
                }
                temp=new StringBuilder();
            }
        }
        int max=Integer.MIN_VALUE;
        String ans = "";
        for(Map.Entry<String,Integer>entry:map.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                 ans = entry.getKey();
            }
        }
        return ans;
    }
}
