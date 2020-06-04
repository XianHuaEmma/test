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
public class FuWuQi {
    public static void main(String[] args) {
        FuWuQi cpu = new FuWuQi();
        int[]arr = new int[]{1,2,1,2,3,4};
        System.out.println(cpu.getComputer(arr));
    }
    public int getComputer(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=list.get(i)){
                res++;
            }
        }
        return res;

    }
}
