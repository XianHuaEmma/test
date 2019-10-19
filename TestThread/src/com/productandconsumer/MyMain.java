package com.productandconsumer;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019.10.20 1:20
 */
public class MyMain {
    public static void main(String[] args) {
        ProductPool pool = new ProductPool(10);
        new Productor(pool).start();
        new Consumer(pool).start();
    }
}
