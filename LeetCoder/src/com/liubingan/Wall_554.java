package com.liubingan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Wall_554 {
    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        int[][] arr = {{1, 2, 2, 1}, {3, 1, 2}, {1, 3, 2}, {2, 4}, {3, 1, 2}, {1, 3, 1, 1}};

        for (int i = 0; i < 6; i++) {
            int[] temp = arr[i];
            List<Integer> tlist = new ArrayList<>();
            for (int num : temp) {
                tlist.add(num);
            }
            wall.add(tlist);
        }
        System.out.println(leastBricks(wall));
    }

    //    public static int leastBricks(List<List<Integer>> wall) {
//        Map<Integer, Integer> count = new HashMap<>();
//        for (int i = 0; i < wall.size(); i++) {
//            List<Integer> list = wall.get(i);
//            int j = 0;
//            for (int temp : list) {
//                if (i == 0) {
//                    while (temp >= 1) {
//                        count.put(j, 1);
//                        temp--;
//                        j++;
//                    }
//                    count.put(j, 0);
//                    j++;
//
//                } else {
//                    while (temp >= 1) {
//                        count.put(j, count.getOrDefault(j, 0) + 1);
//                        temp--;
//                        j++;
//                    }
//                    count.put(j, count.getOrDefault(j, 0));
//                    j++;
//                }
//            }
//        }
//        int res = count.get(0);
//        for (int i = 1; i < count.size() - 1; i++) {
//            if (count.get(i) < res) {
//                res = count.get(i);
//            }
//        }
//        return res;
//    }
    public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum))
                    map.put(sum, map.get(sum) + 1);
                else
                    map.put(sum, 1);
            }
        }
        int res = wall.size();
        for (int key : map.keySet())
            res = Math.min(res, wall.size() - map.get(key));
        return res;
    }

}
