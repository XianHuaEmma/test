package com.liubingang.satrt;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class StartDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        MyRunnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);
        t2.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
