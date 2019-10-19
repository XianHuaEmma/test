package com.test;

public class SynchronizeSection {
    public static void main(String[] args) {
        Runnable myThread = ()->{

            while(TickSale.ticketCount>0){
                synchronized (""){
                    if (TickSale.ticketCount<=0) {
                        return;
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出一张票"+ --TickSale.ticketCount);

                }


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

class TickSale {
    public static  int ticketCount = 100;
}
