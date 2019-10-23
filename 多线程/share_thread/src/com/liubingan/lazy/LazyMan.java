package com.liubingan.lazy;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019 1:21
 */

/**
 * ①private修饰的构造方法：不能通过new的方式获取对象的实例，只能通过调用类的
 * 静态方法获得，但是在类的内部可以通过new方式创建实例
 * ②多线程条件下如果不加锁，会破坏懒汉的单例模式
 */

public class LazyMan {
    public static void main(String[] args) {


        for(int i = 0;i<100 ;i++) {
            LazyInstance.getInstance();
        }
    }

}


