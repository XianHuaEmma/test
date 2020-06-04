package com.liubingan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class ZigZag {
    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int num = 3;
        System.out.println(convert(s, num));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
//        String[] rows = new String[Math.min(s.length(), numRows)];
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());
        int curRow = 0;
        boolean flag = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {// 当前行curRow为0或numRows -1时，箭头发生反向转折
                flag = !flag;
            }
            curRow += flag ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : rows) {
            res.append(temp);
        }
        return res.toString();
    }
}
