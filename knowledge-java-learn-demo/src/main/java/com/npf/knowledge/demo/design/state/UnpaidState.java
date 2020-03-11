package com.npf.knowledge.demo.design.state;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.state
 * @ClassName: UnpaidState
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 10:19
 * @Version: 1.0
 */
public class UnpaidState implements State {



    @Override
    public int getState() {
        //代表未支付状态
        return 0;
    }

    @Override
    public void disposePay(SettleParameter settleParameter) {
        //根据未支付的状态来处理这些业务
        System.out.println("订单是待支付的状态，处理订单");
    }
}
