package com.second;

import java.util.List;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class Wall {
    public int leastBricks(List<List<Integer>> wall) {
        List<Integer> first = wall.get(0);
        int sum = 0;
        for (int i : first) {
            sum += i;
        }
        int []ans = new int[sum];
        for(List<Integer>list:wall){
            int start =0;
            for(int item:list){
                while(item>1) {
                    ans[start] += 1;
                    item--;
                    start++;
                }
                start++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < sum; i++) {
            if(ans[i]<res){
                res = ans[i];
            }
        }
        return res;
    }
}
