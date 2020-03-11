package com.npf.knowledge.demo.design.adapter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.adapter
 * @ClassName: AliPayer
 * @Author: ningpf
 * @Description: 支付宝的支付实现
 * @Date: 2020/2/5 10:33
 * @Version: 1.0
 */
public class AliPayer implements Payer {
    public void doPay() {
        System.out.println("支付宝提交支付");
    }

    public void doQuery() {
        System.out.println("支付宝查询支付");
    }

    public void doBack() {
        System.out.println("支付宝退支付");
    }
}
