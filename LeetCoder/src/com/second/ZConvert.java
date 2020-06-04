package com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class ZConvert {
    public String convert(String s, int numRows) {
        if (s.length() == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        boolean goDown = false;
        int curRow = 0;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goDown = !goDown;
            }
            curRow += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : rows) {
            res.append(temp);
        }
        return res.toString();
    }
}
