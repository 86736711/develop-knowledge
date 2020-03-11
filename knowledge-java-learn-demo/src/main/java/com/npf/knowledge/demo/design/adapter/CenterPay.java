package com.npf.knowledge.demo.design.adapter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.adapter
 * @ClassName: CenterPay
 * @Author: ningpf
 * @Description: 这时项目需求需要对接中信支付，而且中信支付原来还写过，已经很稳当的代码了。或者已在项目使用的代码库了不能修改或者新作。
 * @Date: 2020/2/5 10:35
 * @Version: 1.0
 */
public class CenterPay {

    public void create(){
        System.out.println("中信支付创建");
    }

    public void select(){
        System.out.println("中信支付查询");
    }

    public void delete(){
        System.out.println("中信支付退款");
    }

}
