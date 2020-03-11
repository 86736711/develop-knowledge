package com.npf.knowledge.demo.design.visitor.settle;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator.settle
 * @ClassName: SettleElement
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 12:45
 * @Version: 1.0
 */
public interface SettleElement {

    void accept(SettleVisitor visitor);
}
