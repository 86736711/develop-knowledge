package com.npf.knowledge.demo.design.state;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.state
 * @ClassName: PaidState
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 10:20
 * @Version: 1.0
 */
public class PaidState implements State {
    @Override
    public int getState() {
        // 代表已支付状态
        return 1;
    }

    @Override
    public void disposePay(SettleParameter settleParameter) {

        //根据已支付的状态来处理这些业务
        System.out.println("订单已经支付完了，处理订单");
    }
}
