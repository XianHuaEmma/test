package com.liubingan;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class Ping_933 {
    Queue<Integer>queue;
    public Ping_933(){
        queue=new LinkedList<>();
    }
    int ping(int t){
        queue.add(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
}
