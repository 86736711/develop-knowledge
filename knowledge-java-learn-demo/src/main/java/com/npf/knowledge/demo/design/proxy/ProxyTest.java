package com.npf.knowledge.demo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.proxy
 * @ClassName: ProxyTest
 * @Author: ningpf
 * @Description: 代理模块的测试
 * @Date: 2020/1/16 18:27
 * @Version: 1.0
 */
public class ProxyTest {

    public static void main(String[] args) {


        Man man = new Woman();

        InvocationHandler invocationHandler = new ManInvocationHandler<Man>(man);

        Man manProxy = (Man) Proxy.newProxyInstance(Man.class.getClassLoader(), new Class<?>[]{Man.class}, invocationHandler);

        manProxy.run();
    }
}
