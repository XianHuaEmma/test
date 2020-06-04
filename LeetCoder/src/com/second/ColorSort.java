package com.second;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class ColorSort {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int p0 = 0;
        int p2 = len - 1;
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                int temp = nums[p0];
                nums[p0]=nums[cur];
                nums[cur] = temp;
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[p2];
                nums[p2]=nums[cur];
                nums[cur] = temp;
                p2--;
            } else {
                cur++;
            }
        }
    }
}
