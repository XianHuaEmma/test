package com.liubingan;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Two {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                ans[0] = map.get(num);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such answer");
    }
}
