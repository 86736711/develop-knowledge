package com.npf.knowledge.demo.design.singleton;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.singleton
 * @ClassName: SynBuilderSingleton
 * @Author: ningpf
 * @Description: 内部构建者模式的单例，优点：高效，线程安全，缺点：方法区域的内存稍微大一些，这种模式是最简洁也安全性能最佳的
 * @Date: 2020/1/3 15:18
 * @Version: 1.0
 */
public class SynBuilderSingleton {

    //这种模式就是构建者的模式，只不过用作单例
    private static class Builder{
        private static SynBuilderSingleton synBuilderSingleton = new SynBuilderSingleton();
    }

    private SynBuilderSingleton(){}

    public static SynBuilderSingleton getInstance(){
        return Builder.synBuilderSingleton;
    }

}
