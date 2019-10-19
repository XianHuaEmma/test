package com.productandconsumer;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019.1020 1:04
 */
public class Productor extends Thread {

    private  ProductPool pool;
    public Productor( ProductPool pool) {
        this.pool = pool;
    }

    @Override
    public void run(){
        while(true){
            String name = (int )(Math.random()* 100)  + "号产品";
            Product product = new Product(name);

            this.pool.push(product);
            System.out.println("生产者生产了产品"+name);
        }
    }
}
