package com.liubingan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Less_move {
    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        System.out.println(getLess(nums));
    }
    public static int getLess(int[]nums){

       List<Integer>list = new ArrayList<>();
      for(int temp:nums){
          list.add(temp);
      }
        Collections.sort(list);
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=list.get(i)){
                count++;
            }
        }
        return count/2;
    }
}
