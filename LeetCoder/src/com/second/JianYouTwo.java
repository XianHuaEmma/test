package com.second;

/**
 * @Author：liubingan
 * @date: 134
 * @描述：
 */
public class JianYouTwo {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur_gas = 0;
        int total_gas = 0;
        int station = 0;
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            cur_gas += gas[i] - cost[i];
            total_gas += gas[i] - cost[i];
            if (cur_gas < 0) {
                cur_gas = 0;
                station = i + 1;
            }
        }
        return total_gas >= 0 ? station : -1;
    }
}
