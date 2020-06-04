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
public class RelativeSort_1122 {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        System.out.println(relativeSortArray(arr1, arr2).toString());
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int len2 = arr2.length;
        if (len2 < 1) {
            return arr1;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < len2; i++) {
            list.add(arr2[i]);
        }
        for (int num : arr1) {
            if (!list.contains(num)) {
                list2.add(num);
            } else {
                int index = list.indexOf(num);
                list.add(index, num);
            }
        }
        Collections.sort(list2);
        list.addAll(list2);
        for (int num : arr2) {
            int index = list.indexOf(num);
            list.remove(index);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
