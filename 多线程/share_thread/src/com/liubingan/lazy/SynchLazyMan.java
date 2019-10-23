package com.liubingan.lazy;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class SynchLazyMan {
    private SynchLazyMan()

    {
        System.out.println("LazyMan被加载了");
    }

    private static SynchLazyMan instance = null;

    /*public static synchronized SynchLazyMan getInstance() {
        if (instance == null) {
            instance = new SynchLazyMan();
        }
        return instance;
    }*/
    public static  SynchLazyMan getInstance() {
        synchronized ("") {
            if (instance == null) {
                instance = new SynchLazyMan();
            }
        }
        return instance;
    }


}
