package com.liubingan;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class GeneratePartenthees {

    public List<String> generateParenthesis(int n) {
        List<String> parenthese = new ArrayList<>();
        if (n == 0) {
            return parenthese;
        }
        generate(parenthese, "", n, n);
        return parenthese;
    }

    private void generate(List<String> list, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(cur);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            generate(list, cur + "(", left - 1, right);
        }
        if (right > 0) {
            generate(list, cur + ")", left, right - 1);
        }
    }
}
