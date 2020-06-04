package com.liubingan;

import java.util.*;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Task_621 {

    public static void main(String[] args) {
        char[] arr = {'A', 'A', 'A', 'B', 'B', 'B'};
        leastInterval(arr, 2);
    }

    public static int leastInterval(char[] tasks, int n) {
//        int[] list = new int[26];
//        for (char ch : tasks) {
//            list[ch - 'A']++;
//        }
//        Arrays.sort(list);
//        int time = 0;
//
//        while (list[25] > 0) {
//            int i = 0;
//            while (i <= n) {
//                if (list[25] == 0) {
//                    break;
//                }
//                if (i < 26 && list[25 - i] > 0){
//                    list[25 - i]--;
//
//                }
//                time++;
//                i++;
//            }
//            Arrays.sort(list);
//        }
//        return time;
        int[] map = new int[26];
        for (char ch : tasks) {
            map[ch - 'A']++;
        }
        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Comparator.reverseOrder());
        for (int fr : map) {
            queue.add(fr);
        }
        int times = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        list.add(queue.poll() - 1);
                    } else {
                        queue.poll();
                    }
                }
                times++;
                if (queue.isEmpty() && list.size() == 0) {
                    break;
                }
                i++;
            }
            for (int temp : list) {
                queue.add(temp);
            }
        }
        return times;
    }

    static int getfinal(int value, int n) {
        int res = 0;
        int fre = value / 2;
        if (value % 2 == 0) {
            res = res + (fre - 1) * n + value;
        } else {
            res = res + fre * n + value;
        }
        return res;
    }
}
