package com.npf.knowledge.demo.design.mediator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator
 * @ClassName: Mediator
 * @Author: ningpf
 * @Description: 中介模式的标准，中介的含义就是所有的事情我都帮你干
 * @Date: 2020/2/7 11:57
 * @Version: 1.0
 */
public interface Mediator {


    void contact(String data, MediatorTask mediatorTask);

}
