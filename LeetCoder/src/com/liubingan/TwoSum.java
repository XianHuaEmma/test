package com.liubingan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class TwoSum {
    public static void main(String[] args) {
        int []arr = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        int len  = nums.length;
        for (int i = 0; i <len ; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < len; i++) {
            int temp = target-nums[i];
            if(map.containsKey(temp)&& map.get(temp)!=i){
                return new int[]{i,map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
