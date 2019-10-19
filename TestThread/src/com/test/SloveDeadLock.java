package com.test;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019/10/19 0:51
 */
public class SloveDeadLock {
    /**
     *wait():属于Object方法，会释放当前线程持有的锁标记，释放CPU资源，同时进入线程等待队列
     * notify（）：属于Object方法，唤醒等待队列中的线程，使该线程进入锁池中
     * notifyAll():属于Object方法，唤醒等待队列中的所有线程，使这些线程进入锁池中
     * @param args
     */

    public static void main(String[] args) {
        Runnable runnable1 = ()->{
            synchronized ("A"){
                System.out.println("A持有A锁");
                try {
                    "A".wait();
                }catch(Exception e) {
                    e.printStackTrace();
                }

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
                    "A".notifyAll();
                }
            }

        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
