package com.second;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Faguan {
    public int findJudge(int N, int[][] trust) {
        if(N==1){
            return 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,Integer>mark = new HashMap<>();
        for (int[] arr : trust) {
            map.put(arr[1], map.getOrDefault(arr[1], 0) + 1);
            mark.put(arr[0],arr[1]);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N - 1 && !mark.containsKey(entry.getKey())) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
