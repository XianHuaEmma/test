package com.liubingan.method;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class SetPriorityDemo {
    public static void main(String[] args) {
        Runnable r = ()->{
            for (int i = 0; i <30 ; i++) {
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        };

        Thread t1 = new Thread(r,"高优先级");
        Thread t2 = new Thread(r,"默认优先级");
        // 先设置再启动
        t1.setPriority(9);
        t2.start();
        t1.start();
    }

}
