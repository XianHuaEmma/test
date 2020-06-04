package com.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class InvalidTransation {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        List<Transaction> tran = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            String[] info = transactions[i].split(",");
            String name = info[0];
            int time = Integer.parseInt(info[1]);
            int money = Integer.parseInt(info[2]);
            String city = info[3];
            tran.add(new Transaction(name, time, money, city));
        }
        for (int i = 0; i < tran.size(); i++) {
            if (tran.get(i).money > 1000) {
                ans.add(transactions[i]);
            } else {
                for (int j = 0; j < tran.size(); j++) {
                    if (i != j && tran.get(j).name.equals(tran.get(i).name) && !tran.get(j).city.equals(tran.get(i).city)
                            && Math.abs(tran.get(j).time - tran.get(i).time) <= 60) {
                        ans.add(transactions[i]);
                        break;
                    }
                }

            }
        }
        return ans;
    }

    class Transaction {
        String name;
        int time;
        int money;
        String city;

        public Transaction(String name, int time, int money, String city) {
            this.name = name;
            this.time = time;
            this.money = money;
            this.city = city;
        }
    }
}
