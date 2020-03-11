package com.npf.knowledge.demo.design.proxy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.proxy
 * @ClassName: ManProxy
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/16 15:57
 * @Version: 1.0
 */
public class ManProxy implements Man{

    private Man man = new Woman();

    public void run() {
        //干什么都行

        man.run();

        //干什么都行
    }


}
