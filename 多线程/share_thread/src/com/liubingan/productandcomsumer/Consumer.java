package com.liubingan.productandcomsumer;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019.10.20 1:17
 */
public class Consumer extends Thread{
    private  ProductPool pool;
    public Consumer( ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run(){
        while(true){

            Product product = this.pool.pop();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("消费者者消费了产品"+product.getName());
        }
    }
}
