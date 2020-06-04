package com.second;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class WallTwo {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map = new HashMap<>();
        for(List<Integer>row:wall){
            int sum = 0;
            for(int i=0;i<row.size()-1;i++){
                sum += row.get(i);
                if(map.containsKey(sum)){
                    map.put(sum,map.get(sum)+1);
                } else {
                    map.put(sum,1);
                }
            }
        }
        int res = wall.size();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            res = Math.min(res,wall.size()-entry.getValue());
        }
        return res;
    }
}
