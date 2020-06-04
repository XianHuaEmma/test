package com.liubingan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Merge_56 {

    private static class IntervalComparator implements Comparator<int[]> {

        @Override
        public int compare(int[] arr1, int[] arr2) {
            return Integer.compare(arr1[0], arr2[0]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new IntervalComparator());

        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

        int[] cur_intervals = intervals[0];
        List<int[]> res = new ArrayList<>();
        res.add(cur_intervals);
        for (int[] interval : intervals) {
            int cur_satrt = cur_intervals[0];
            int cur_end = cur_intervals[1];
            int new_start = interval[0];
            int new_end = interval[1];
            if (cur_end >= new_start) {
                cur_end = Math.max(cur_end, new_end);
                cur_intervals[1] = cur_end;
            } else {
                res.add(interval);
                cur_intervals = interval;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
