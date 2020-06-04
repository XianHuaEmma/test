package com.liubingan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class DistantSort_1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});
        boolean[][] isvisit = new boolean[R][C];
        isvisit[r0][c0] = true;
        int[][] ans = new int[R * C][2];
        int num = 0;

        while (!queue.isEmpty()) {
            List<int[]> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] node = queue.removeFirst();
                ans[num] = node;
                num++;
                nodeList.add(node);
            }
            for (int[] node : nodeList) {
                int row = node[0];
                int col = node[1];
                //上
                if (row > 0 && !isvisit[row - 1][col]) {
                    isvisit[row - 1][col] = true;
                    queue.add(new int[]{row - 1, col});
                }
                //下
                if (row < R - 1 && !isvisit[row + 1][col]) {
                    isvisit[row + 1][col] = true;
                    queue.add(new int[]{row + 1, col});
                }
                //左
                if (col > 0 && !isvisit[row][col - 1]) {
                    isvisit[row][col - 1] = true;
                    queue.add(new int[]{row, col - 1});
                }
                //右
                if (col < C - 1 && !isvisit[row][col + 1]) {
                    isvisit[row][col +1] = true;
                    queue.add(new int[]{row, col + 1});
                }
            }

        }
        return ans;
    }
}
