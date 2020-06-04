package com.second;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author：liubingan
 * @date: 2020
 * @描述：
 */
public class RecentCounter {
    private Queue<Integer>queue;
    public RecentCounter(){
        this.queue = new LinkedList<>();
    }
    public int ping(int t){
        queue.add(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
