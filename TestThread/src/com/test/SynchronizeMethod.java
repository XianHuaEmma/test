package com.test;


public class SynchronizeMethod {
    public static void main(String[] args) {
        Runnable myThread = ()->{

            while(TickSale.ticketCount>0){
                /*synchronized (""){
                    sale();

                }*/
                sale2();


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

    private static void sale( ) {
        if (TickSale.ticketCount<=0) {
            return;
        }
        System.out.println(Thread.currentThread().getName()+"卖出一张票"+ --TickSale.ticketCount);
    }
    /**
        *同步方法：
        *静态方法：同步锁就是类锁，当前类.class
        * 非静态方法：同步锁是this
     */
    private synchronized static void sale2(){
        if (TickSale.ticketCount<=0) {
            return;
        }
        System.out.println(Thread.currentThread().getName()+"卖出一张票"+ --TickSale.ticketCount);
    }
}
