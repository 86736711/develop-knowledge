package com.npf.knowledge.demo.design.state;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.state
 * @ClassName: State
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 9:58
 * @Version: 1.0
 */
public interface State {

    int getState();

    void disposePay(SettleParameter settleParameter);

}
