package com.npf.knowledge.demo.design.proxy;

import cn.com.tcsl.s1.design.util.MonitorUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.proxy
 * @ClassName: ManInvocationHandler
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/16 18:23
 * @Version: 1.0
 */
public class ManInvocationHandler<T> implements InvocationHandler {

    T target;

    public ManInvocationHandler(T target) {
        this.target = target;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行" +method.getName() + "方法");

        //代理过程中插入监测方法,计算该方法耗时
        MonitorUtil.start();
        Object result = method.invoke(target, args);
        MonitorUtil.finish(method.getName());
        return result;
    }
}
