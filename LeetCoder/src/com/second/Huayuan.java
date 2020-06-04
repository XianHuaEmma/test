package com.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author：liubingan
 * @date:
 * @描述：
 */
public class Huayuan {
    public static void main(String[] args) {
        Huayuan hua = new Huayuan();
        int N = 4;
        int[][]paths = new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};
        System.out.println(hua.gardenNoAdj(N,paths));
    }
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>>graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i,new HashSet<>());
        }
        //建立邻接表
        for(int[]temp:paths){
            int a = temp[0]-1;
            int b = temp[1]-1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int[] res = new int[N]; //花园的个数
        for (int i = 0; i < N; i++) {
            boolean[] used = new boolean[5];//只有4种花可以选择
            for (int adj: graph.get(i)) {
                used[res[adj]] = true;
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
