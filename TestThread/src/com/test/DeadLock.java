package com.test;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019/10/19 0:31
 */
public class DeadLock {
    public static void main(String[] args) {
        Runnable runnable1 = ()->{
            synchronized ("A"){
                System.out.println("A持有A锁");
                synchronized ("B"){
                    System.out.println("A持有B锁");
                }
            }

        };
        Runnable runnable2 = ()->{
            synchronized ("B"){
                System.out.println("B持有B锁");
                synchronized ("A"){
                    System.out.println("B持有A锁");
                }
            }

        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
