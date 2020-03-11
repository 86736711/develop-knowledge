package com.npf.knowledge.demo.design.adapter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.adapter
 * @ClassName: Payer
 * @Author: ningpf
 * @Description: 支付接口，假设在支付的代码流程中，支付接口已经根据支付类型最终选择相应的支付实现了
 * @Date: 2020/2/5 10:30
 * @Version: 1.0
 */
public interface Payer {

    void doPay();

    void doQuery();

    void doBack();
}
