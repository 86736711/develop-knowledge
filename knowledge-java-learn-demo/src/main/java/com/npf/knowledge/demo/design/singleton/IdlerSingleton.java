package com.npf.knowledge.demo.design.singleton;
/**
 * @ProjectName: tcsl-smart-designmode-demo
 * @Package: cn.com.tcsl.s1.design.singleton
 * @ClassName: IdlerSingleton
 * @Author: ningpf
 * @Description: 懒汉单例，这种模式的优点：降低了初始内容，在需要的时候创建，缺点：在并发的时候会有重复创建的问题（所有的模式没有好坏，只有业务是否使用）
 * @Date: 2020/1/3
 * @Version: 1.0
 */
public class IdlerSingleton {

    private static IdlerSingleton idlerSingleton;

    private IdlerSingleton(){};

    public static IdlerSingleton getInstance(){

        if(idlerSingleton == null){
            //多线程容易同时进入这一步
            idlerSingleton = new IdlerSingleton();
        }

        return idlerSingleton;
    }

}
