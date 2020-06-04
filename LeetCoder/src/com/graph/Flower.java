package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Flower {
    public static void main(String[] args) {
//        int [][]paths = {{1,2},{2,3},{3,1}};
        int [][]paths = {{1,2},{3,4}};
        System.out.println(Arrays.toString(gardenNoAdj(4,paths)));
    }

    public static int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; ++i) list.add(new ArrayList<Integer>());
        for (int[] path : paths) {
            list.get(path[0] - 1).add(path[1] - 1);
            list.get(path[1] - 1).add(path[0] - 1);
        }
        int[] res = new int[N];
        boolean[] colors = new boolean[4];
        res[0] = 1; // 第一个花园种第一种花
        for (int i = 1; i < N; ++i) { //从第二个花园开始
            Arrays.fill(colors, false);
            for (int neighbor : list.get(i)) {   //获取与第二个花园相邻的花园
                if (res[neighbor] != 0) {  // 该花园已有花
                    colors[res[neighbor] - 1] = true;
                }
            }
            for (int color = 0; color < colors.length; ++color) {  // 第i个花园种的花为i+1
                if (colors[color] == false) {
                    res[i] = color + 1;
                    break;
                }
            }
        }
        return res;
    }

}
