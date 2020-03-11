package com.npf.knowledge.demo.design.singleton;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.singleton
 * @ClassName: SynIdlerSingleton
 * @Author: ningpf
 * @Description: 懒汉单例，带锁模式，这种模式的优点：能解决创建的多线程的问题，缺点：因为加入了锁性能差（所有的模式没有好坏，只有业务是否使用）
 * @Date: 2020/1/3 14:55
 * @Version: 1.0
 */
public class SynIdlerSingleton {

    private static SynIdlerSingleton synIdlerSingleton;

    private SynIdlerSingleton(){}

    //这种锁的力度是到对象很粗
    public static synchronized SynIdlerSingleton getSynMethodInstance(){

        if(synIdlerSingleton == null){
            synIdlerSingleton = new SynIdlerSingleton();
        }

        return synIdlerSingleton;

    }


    //代码块锁会有效的提升性能
    public static SynIdlerSingleton getSynInstance(){

        synchronized(SynIdlerSingleton.class){ // 使用 synchronized 块，临界资源的同步互斥访问
            if(synIdlerSingleton == null){
                synIdlerSingleton = new SynIdlerSingleton();
            }
        }

        return synIdlerSingleton;

    }

    //代码块锁会有效的提升性能
    public static SynIdlerSingleton getSynDoubleCheckInstance(){
        if(synIdlerSingleton == null){ // 这个代码提高了锁的争抢情况
            synchronized(SynIdlerSingleton.class){ // 使用 synchronized 块，临界资源的同步互斥访问
                if(synIdlerSingleton == null){
                    synIdlerSingleton = new SynIdlerSingleton();
                }
            }
        }

        return synIdlerSingleton;

    }

}
