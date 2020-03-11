package com.npf.knowledge.demo.design.singleton;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.singleton
 * @ClassName: ThreadSingleton
 * @Author: ningpf
 * @Description: 线程的单例
 * @Date: 2020/1/3 15:26
 * @Version: 1.0
 */
public class ThreadSingleton {
    private static ThreadLocal<ThreadSingleton> threadLocal = new ThreadLocal<ThreadSingleton>();

    private static ThreadSingleton threadSingleton;

    private ThreadSingleton(){}

    public static ThreadSingleton getInstance(){
        // 第一次检查：若线程第一次访问，则进入if语句块；否则，若线程已经访问过，则直接返回ThreadLocal中的值
        if (threadLocal.get() == null) {
            synchronized (ThreadSingleton.class) {
                if (threadSingleton == null) {  // 第二次检查：该单例是否被创建
                    threadSingleton = new ThreadSingleton();
                }
            }
            threadLocal.set(threadSingleton); // 将单例放入ThreadLocal中
        }
        return threadLocal.get();

    }

}
