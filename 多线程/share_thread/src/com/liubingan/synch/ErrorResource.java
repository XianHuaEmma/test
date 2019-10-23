package com.liubingan.synch;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class ErrorResource {
    public static void main(String[] args) {
        Runnable r = ()-> {
            while (Counter.number>0){
                System.out.println(Thread.currentThread().getName()+"数数字"+ --Counter.number+"个");
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
