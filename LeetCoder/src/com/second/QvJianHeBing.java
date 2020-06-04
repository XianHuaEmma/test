package com.second;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class QvJianHeBing {
    private static class IntervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] arr1, int[] arr2) {
            return Integer.compare(arr1[0], arr2[0]);
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new IntervalComparator());
        List<int[]> res = new ArrayList<>();
        int[] cur_interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int cur_end = cur_interval[1];
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (cur_end >= start) {
                cur_interval[1] = Math.max(cur_end, end);
            } else {
                res.add(cur_interval);
                cur_interval = intervals[i];
            }
        }
        res.add(cur_interval);
        return res.toArray(new int[res.size()][]);
    }
}
