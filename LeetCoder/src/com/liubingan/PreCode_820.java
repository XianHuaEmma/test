package com.liubingan;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class PreCode_820 {
    public int minimumLengthEncoding(String[] words) {
        Set<String>dic= new HashSet<>(Arrays.asList(words));
        for(String word:words){
            for (int i = 1; i < word.length(); i++) {
                dic.remove(word.substring(i));
            }
        }
        int ans = 0;
        for(String filter:dic){
            ans = ans+filter.length()+1;
        }
        return ans;
    }
}
