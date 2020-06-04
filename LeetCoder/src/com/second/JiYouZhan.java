package com.second;

/**
 * @Author：liubingan
 * @date: 134
 * @描述：
 */
public class JiYouZhan {
    public static void main(String[] args) {
        JiYouZhan jiyou = new JiYouZhan();
        int[] gas = new int[]{ 2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(jiyou.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int j = i; j < i + n; j++) {
                total += gas[j % n];
                if (total < cost[j % n]) {
                    total = -1;
                    break;
                }
                total -= cost[j % n];
            }
            if (total >= 0) {
                return i ;
            }
        }
        return -1;
    }
}
