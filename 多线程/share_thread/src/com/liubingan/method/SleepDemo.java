package com.liubingan.method;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class SleepDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        },"share线程");
        t1.start();
    }
}
