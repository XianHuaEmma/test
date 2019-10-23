package com.liubingan.synch;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class ReentranLockResource {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable r = ()-> {
            while (Counter.number>0){
                lock.lock();
                if (Counter.number <= 0){
                    return;
                }
                System.out.println(Thread.currentThread().getName()+"数数字 "+ --Counter.number+" :个");
                lock.unlock();

            }
        };
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        Thread t3 = new Thread(r,"线程3");
        Thread t4 = new Thread(r,"线程4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
