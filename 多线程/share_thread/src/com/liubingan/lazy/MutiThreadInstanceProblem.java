package com.liubingan.lazy;

/**
 * @Author：liubingan
 * @date: 2019
 * @描述：
 */
public class MutiThreadInstanceProblem {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            LazymutilInstance.getInstance();

        };

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }

    static class LazymutilInstance {
        private LazymutilInstance()

        {
            System.out.println("LazyMan被加载了");
        }

        private static LazymutilInstance instance = null;

        public static LazymutilInstance getInstance() {
            if (instance == null) {
                instance = new LazymutilInstance();
            }
            return instance;
        }
    }
}
