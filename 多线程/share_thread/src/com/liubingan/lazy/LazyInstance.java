package com.liubingan.lazy;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class LazyInstance {
    private LazyInstance()

    {
        System.out.println("LazyMan被加载了");
    }

    private static LazyInstance instance = null;

    public static LazyInstance getInstance() {
        if (instance == null) {
            instance = new LazyInstance();
        }
        return instance;
    }
}
