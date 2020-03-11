package com.npf.knowledge.demo.design.chain;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.chain
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 责任链模式，是将一个业务按照一个流水线的方式可以进行扩展，这个模式在实际应用中需要解决灵活调整顺序和按照需求是否根据失败将链进行阻断模式
 * @Date: 2020/2/6 15:41
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {
        PayChain payWxChain = new PayChain("微信支付");

        PayChain payAliChain = new PayChain("支付宝支付");

        payWxChain.addPayChain(payAliChain);

        payWxChain.pay();
    }

}
