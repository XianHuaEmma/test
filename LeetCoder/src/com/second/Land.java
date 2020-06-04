package com.second;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Land {
    public static void main(String[] args) {
        int [][]grid = new int[][]{{},{},{}};
    }
    public int maxDistance(int[][] grid) {
        if(grid==null){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        List<position> lands = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    lands.add(new position(i, j));
                }

            }
        }
        if (row == 0 || col == 0) {
            return -1;
        }
        return oceanToLand(grid, lands, 0);

    }

    private int oceanToLand(int[][] grid, List<position> lands, int cur) {
        List<position> newLand = new ArrayList<>();
        for (position land : lands) {
            if (land.row < grid.length - 1 && grid[land.row + 1][land.col] == 0) {
                newLand.add(new position(land.row + 1, land.col));
            }
            if (land.row > 0 && grid[land.row - 1][land.col] == 0) {
                newLand.add(new position(land.row - 1, land.col));
            }
            if (land.col > 0 && grid[land.row][land.col - 1] == 0) {
                newLand.add(new position(land.row, land.col - 1));
            }
            if (land.col < grid[0].length - 1 && grid[land.row][land.col + 1] == 0) {
                newLand.add(new position(land.row, land.col + 1));
            }

        }
        if (newLand.size() == 0) {
            return cur;
        }
        return oceanToLand(grid, newLand, cur + 1);

    }
}

class position {
    int row;
    int col;

    public position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
