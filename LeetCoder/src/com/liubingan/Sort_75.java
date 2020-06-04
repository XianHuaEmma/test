package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Sort_75 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        int cur = 0;
        int len = nums.length;
        int p2 = len - 1;
        int p0 = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                int temp = nums[cur];
                nums[cur] = nums[p0];
                nums[p0] = temp;
                p0++;
                cur++;
            } else if (nums[cur] == 2) {
                int temp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = 2;
                p2--;
            } else {
                cur++;
            }
        }

    }
}
