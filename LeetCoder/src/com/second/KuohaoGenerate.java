package com.second;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class KuohaoGenerate {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backSearch(ans, "", n, n);
        return ans;

    }

    public void backSearch(List<String> res, String curStr, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }
        if (right < left) {
            return;
        }
        if (left > 0) {
            backSearch(res, curStr + "(", left - 1, right);
        }
        if (right > 0) {
            backSearch(res, curStr + ")", left, right - 1);
        }

    }
}
