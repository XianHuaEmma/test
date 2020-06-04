package com.binary;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class FindOrInsert {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        int target = 6;
        System.out.println(searchInsert(arr, target));
    }

    //    public static int searchInsert(int[] nums, int target) {
//        int lastIndex = nums.length - 1;
//        int index = 0;
//        boolean flag = true;
//        for (int i = 0; i < nums.length && i < lastIndex - i; i++) {
//            if (nums[i] == target) {
//                return i;
//            } else if (nums[lastIndex - i] == target) {
//                return lastIndex - i;
//            } else if (nums[i] > target && flag) {
//                index = i;
//                flag = false;
//            } else if (nums[lastIndex - i] < target && flag) {
//                index = lastIndex - i + 1;
//                flag = false;
//            }
//        }
//        return index;
//    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }
}
