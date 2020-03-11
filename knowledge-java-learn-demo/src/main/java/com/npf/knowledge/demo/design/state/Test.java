package com.npf.knowledge.demo.design.state;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.state
 * @ClassName: Test
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 10:47
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        SettleParameter settleParameter = new SettleParameter();

        SettleDispose settleDispose = new SettleDispose();

        settleDispose.setSettleParameter(settleParameter);

        //订单是未支付的状态进行处理
        settleDispose.setState(new UnpaidState());
        settleDispose.commit();

        //订单是已支付的状态进行处理
        settleDispose.setState(new PaidState());
        settleDispose.commit();


    }

}
