package com.npf.knowledge.demo.design.chain;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.chain
 * @ClassName: PayChain
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 15:36
 * @Version: 1.0
 */
public class PayChain {

    private String payName;

    private PayChain payChain;

    public PayChain(String payName){
        this.payName = payName;
    }


    public void pay(){
        System.out.println(payName+"支付啦");
        if(payChain!=null){
            payChain.pay();
        }
    }

    public void addPayChain(PayChain payChain){
        this.payChain = payChain;
    }


}
