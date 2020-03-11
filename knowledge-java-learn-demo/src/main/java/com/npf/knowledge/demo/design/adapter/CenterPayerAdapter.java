package com.npf.knowledge.demo.design.adapter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.adapter
 * @ClassName: CenterPayerAdapter
 * @Author: ningpf
 * @Description: 这时候就需要一个适配器，适配到现有的代码中。
 * @Date: 2020/2/5 10:37
 * @Version: 1.0
 */
public class CenterPayerAdapter implements Payer {

    private CenterPay centerPay;

    public CenterPayerAdapter(CenterPay centerPay){
        this.centerPay = centerPay;
    }


    public void doPay() {
        centerPay.create();
    }

    public void doQuery() {
        centerPay.select();
    }

    public void doBack() {
        centerPay.delete();
    }
}
