package com.liubingan;
/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class Dfs_SerachMat_12 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        if (row < 1 || word.length() < 1) {
            return false;
        }
        int col = board[0].length;
        if (row * col < word.length()) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char temp = board[i][j];
                    board[i][j] = '/';
                    if (dfs(board, word, 1, i, j, row, col, word.length())) {
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int bordStartRow, int boardStartCol, int row, int col, int strLen) {
        if (wordIndex >= strLen) {
            return true;
        }
        //向上
        if(bordStartRow>0&&board[bordStartRow-1][boardStartCol]==word.charAt(wordIndex)){
            char temp = board[bordStartRow-1][boardStartCol];
            board[bordStartRow-1][boardStartCol] ='/';
            if(dfs(board,word,wordIndex+1,bordStartRow-1,boardStartCol,row,col,strLen)){
                return true;
            }
            board[bordStartRow-1][boardStartCol] = temp;
        }
        //向左
        if(boardStartCol>0&&board[bordStartRow][boardStartCol-1]==word.charAt(wordIndex)){
            char temp = board[bordStartRow][boardStartCol-1];
            board[bordStartRow][boardStartCol-1] ='/';
            if(dfs(board,word,wordIndex+1,bordStartRow,boardStartCol-1,row,col,strLen)){
                return true;
            }
            board[bordStartRow][boardStartCol-1] = temp;
        }
        //向下
        if(bordStartRow<row-1&&board[bordStartRow+1][boardStartCol]==word.charAt(wordIndex)){
            char temp = board[bordStartRow+1][boardStartCol];
            board[bordStartRow+1][boardStartCol] ='/';
            if(dfs(board,word,wordIndex+1,bordStartRow+1,boardStartCol,row,col,strLen)){
                return true;
            }
            board[bordStartRow+1][boardStartCol] = temp;
        }
        //向右
        if(boardStartCol<col-1&&board[bordStartRow][boardStartCol+1]==word.charAt(wordIndex)){
            char temp = board[bordStartRow][boardStartCol+1];
            board[bordStartRow][boardStartCol+1] ='/';
            if(dfs(board,word,wordIndex+1,bordStartRow,boardStartCol+1,row,col,strLen)){
                return true;
            }
            board[bordStartRow][boardStartCol+1] = temp;
        }
        return false;
    }

}
