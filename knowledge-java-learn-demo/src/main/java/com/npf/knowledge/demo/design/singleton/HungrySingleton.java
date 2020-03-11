package com.npf.knowledge.demo.design.singleton;
/**
 * @ProjectName: tcsl-smart-designmode-demo
 * @Package: cn.com.tcsl.s1.design.singleton
 * @ClassName: HungrySingleton
 * @Author: ningpf
 * @Description: 恶汉单例，这种模式的有点：是性能高，缺点：提前占用空间（所有的模式没有好坏，只有业务是否使用）
 * @Date: 2020/1/3
 * @Version: 1.0
 */
public class HungrySingleton {

    private static HungrySingleton idlerSingleton = new HungrySingleton();

    private HungrySingleton(){};

    public static HungrySingleton getInstance(){
        return idlerSingleton;
    }

}
