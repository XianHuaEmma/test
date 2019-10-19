package com.test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019/10/18 1:54
 */
public class ReentranlockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Runnable myThread = ()->{

            while(TickSale.ticketCount>0){
                    lock.lock();
                    if (TickSale.ticketCount<=0) {
                        return;
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出一张票"+ --TickSale.ticketCount);

                    lock.unlock();


            }


        };

        Thread t1 = new Thread(myThread, "thread -1");
        Thread t2 = new Thread(myThread, "thread -2");
        Thread t3 = new Thread(myThread, "thread -3");
        Thread t4 = new Thread(myThread, "thread -4");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

