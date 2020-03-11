package com.npf.knowledge.demo.design.adapter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.adapter
 * @ClassName: WxPayer
 * @Author: ningpf
 * @Description: 微信支付的实现
 * @Date: 2020/2/5 10:31
 * @Version: 1.0
 */
public class WxPayer implements Payer {
    public void doPay() {
        System.out.println("微信提交支付");
    }

    public void doQuery() {
        System.out.println("微信查询支付");
    }

    public void doBack() {
        System.out.println("微信退支付");
    }
}
