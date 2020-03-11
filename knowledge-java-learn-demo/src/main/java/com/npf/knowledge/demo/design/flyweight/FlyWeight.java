package com.npf.knowledge.demo.design.flyweight;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.flyweight
 * @ClassName: FlyWeight
 * @Author: ningpf
 * @Description: 一个普通的接口，处理数据的接口，享元模式，也叫轻量级模式的目的就是减少对象的产生，将对象共享来做到轻量级
 * @Date: 2020/2/5 17:28
 * @Version: 1.0
 */
public interface FlyWeight {

    void action(String data);
}
