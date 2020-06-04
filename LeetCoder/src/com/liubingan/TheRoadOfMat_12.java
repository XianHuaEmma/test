package com.liubingan;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class TheRoadOfMat_12 {
    class Solution {
        public boolean exist(char[][] board, String word) {
            int rowNum = board.length;
            if(rowNum < 1 || word.length() < 1) return false;
            int colNum = board[0].length;
            if(colNum * rowNum < word.length()) return false; // 总个数小于单词数量，没必要遍历了，这个优化很有必要
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] == word.charAt(0)) {
                        char temp = board[i][j];
                        board[i][j] = '.'; // 修改临时的值，避免重复访问
                        if(doSelect(board, word, 1, i, j, rowNum, colNum, word.length())) return true;
                        board[i][j] = temp;
                    }
                }
            }

            return false;
        }

        /**
         * 递归思想：每遍历一个之后，分别遍历前后上下的，并且把访问过的元素改成特定的元素值，避免后续搜索的时候重复访问
         * 这里顺序也挺重要的可能跟测试用例有关吧，但是通常也建议右下在前面
         * @param board
         * @param word
         * @param searchIndex 要搜索的元素所在字符串的下标
         * @param startRow 从哪个行开始
         * @param startCol 从哪个列开始
         * @param rowNum 二维数组行数
         * @param colNum 二维数组列数
         * @param strLen 字符串长度
         * @return
         */
        private boolean doSelect(char[][] board, String word, int searchIndex, int startRow, int startCol, int rowNum, int colNum, int strLen){
            if(searchIndex > strLen - 1) return true;
            // 向右
            if(startCol < colNum - 1 && word.charAt(searchIndex) == board[startRow][startCol + 1]){
                char temp = board[startRow][startCol + 1];
                board[startRow][startCol + 1] = '.';
                if(doSelect(board, word, searchIndex + 1, startRow, startCol + 1, rowNum, colNum, strLen)) return true;
                board[startRow][startCol + 1] = temp;
            }
            // 向下
            if(startRow < rowNum - 1 && word.charAt(searchIndex) == board[startRow+1][startCol]){
                char temp = board[startRow+1][startCol];
                board[startRow+1][startCol] = '.';
                if(doSelect(board, word, searchIndex + 1, startRow + 1, startCol, rowNum, colNum, strLen)) return true;
                board[startRow+1][startCol] = temp;
            }
            // 向左
            if(startCol > 0 && word.charAt(searchIndex) == board[startRow][startCol-1]){
                char temp = board[startRow][startCol-1];
                board[startRow][startCol-1] = '.';
                if(doSelect(board, word, searchIndex + 1, startRow, startCol - 1, rowNum, colNum, strLen)) return true;
                board[startRow][startCol-1] = temp;
            }
            // 向上
            if(startRow > 0 && word.charAt(searchIndex) == board[startRow-1][startCol]){
                char temp = board[startRow-1][startCol];
                board[startRow-1][startCol] = '.';
                if(doSelect(board, word, searchIndex + 1, startRow - 1, startCol, rowNum, colNum, strLen)) return true;
                board[startRow-1][startCol] = temp;
            }

            return false;
        }
    }


}
