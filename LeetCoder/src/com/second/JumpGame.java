package com.second;

/**
 * @Author：liubingan
 * @date: 55
 * @描述： 每次遍历维护最大的可达距离
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int most = 0;
        for (int i = 0; i < n; i++) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
