package com.test;

/**
 * @author liubingang
 * @version 1.0
 * @date 2019 1:46
 */

/**
 * 将可能出现多线程误触的地方加入synchronize，方法加或者是代码块中加
 */

public class SynchronizeSloveLazy {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            LazyInstance2.getInstance();

        };

        for(int i = 0;i<100 ;i++) {
            new Thread(runnable).start();
        }
    }
}

class LazyInstance2 {
    private LazyInstance2()

    {
        System.out.println("LazyMan被加载了");
    }

    private static LazyInstance2 instance = null;

    /*public static LazyInstance2 getInstance() {
        synchronized (""){
            if (instance == null) {
                instance = new LazyInstance2();
            }
        }

        return instance;
    }*/

    public synchronized  static LazyInstance2 getInstance() {

            if (instance == null) {
                instance = new LazyInstance2();
            }


        return instance;
    }
}
