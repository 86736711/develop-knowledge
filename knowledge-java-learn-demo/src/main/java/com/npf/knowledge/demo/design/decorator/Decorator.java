package com.npf.knowledge.demo.design.decorator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.decorator
 * @ClassName: Decorator
 * @Author: ningpf
 * @Description: 定义了装饰这个人的标准api
 * @Date: 2020/2/5 16:46
 * @Version: 1.0
 */
public interface Decorator extends People {

    void wearBefore();

    void wearAfter();
}
