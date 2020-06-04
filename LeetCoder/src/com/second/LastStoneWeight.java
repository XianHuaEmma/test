package com.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        LastStoneWeight last = new LastStoneWeight();
        int []stone=new int[]{2,4,3,1,8,1};
        System.out.println(last.lastStoneWeight(stone));
    }
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();

        for (int i : stones) {
            list.add(i);
        }
        Collections.sort(list, (w1, w2) -> w1 == w2 ? w1 - w2 : w2.compareTo(w1));
        while (list.size() > 1) {
            int y = list.remove(0);
            int x = list.remove(0);
            if (x < y) {
                list.add(y-x);
            }
            Collections.sort(list, (w1, w2) -> w1 == w2 ? w1 - w2 : w2.compareTo(w1));
        }
        if(list.size()>0){
            return list.get(0);
        }
        return 0;

    }
}
