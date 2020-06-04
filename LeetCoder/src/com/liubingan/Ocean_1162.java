package com.liubingan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Ocean_1162 {
    public int maxDistance(int[][] grid) {
        if (grid == null)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        /* 记录所有陆地的位置 */
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = grid[i][j];
                if (value == 1) {
                    positions.add(new Position(i, j));

                }
            }
        }
        if (positions.size() == 0 || positions.size() == row * col) {
            return -1;
        }
        return getMax(grid, positions, 0);

    }

    private Integer getMax(int[][] grid, List<Position> positions, Integer curr) {

        List<Position> levelPosition = new ArrayList<>();
        for (Position position : positions) {
            if (position.row - 1 >= 0) { // 同列上一行
                if (grid[position.row - 1][position.col] != 1) {
                    levelPosition.add(new Position(position.row - 1, position.col));
                    grid[position.row - 1][position.col] = 1; // 遍历过的则标记位1
                }
            }
            if (position.row + 1 < grid.length) { // 同列下一行
                if (grid[position.row + 1][position.col] != 1) {
                    levelPosition.add(new Position(position.row + 1, position.col));
                    grid[position.row + 1][position.col] = 1;
                    int a = Integer.MAX_VALUE;
                }
            }
            if (position.col - 1 >= 0) { // 左边列
                if (grid[position.row][position.col - 1] != 1) {
                    levelPosition.add(new Position(position.row, position.col - 1));
                    grid[position.row][position.col - 1] = 1;
                }
            }
            if (position.col + 1 < grid[0].length) { // 右边列
                if (grid[position.row][position.col + 1] != 1) {
                    levelPosition.add(new Position(position.row, position.col + 1));
                    grid[position.row][position.col + 1] = 1;
                }
            }

        }
        if (levelPosition.size() == 0) {
            return curr;
        }
        return getMax(grid, levelPosition, curr + 1); //
    }

    // 定义每个节点的坐标
    class Position {
        public Integer row;

        public Integer col;

        public Position(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }
}
