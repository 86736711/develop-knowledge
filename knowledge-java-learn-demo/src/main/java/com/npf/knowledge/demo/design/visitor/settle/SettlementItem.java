package com.npf.knowledge.demo.design.visitor.settle;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator.settle
 * @ClassName: SettlementItem
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 12:47
 * @Version: 1.0
 */
public class SettlementItem implements SettleElement {
    @Override
    public void accept(SettleVisitor visitor) {

        System.out.println("中介SettleVisitor帮我做一些事情");

        visitor.visit(this);
    }
}
