package com.liubingan.method;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class YeldDemo {
    public static void main(String[] args) {
        Runnable r = ()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread().getName()+": "+i);
                if ((i % 3) == 0) {
                    Thread.yield();
                }
            }
        };
        Thread t1 = new Thread(r,"线程1");
        Thread t2 = new Thread(r,"线程2");
        t1.start();
        t2.start();
    }
}
