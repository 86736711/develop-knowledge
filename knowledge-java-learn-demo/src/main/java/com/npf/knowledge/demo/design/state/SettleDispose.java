package com.npf.knowledge.demo.design.state;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.state
 * @ClassName: SettleDispose
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 10:42
 * @Version: 1.0
 */
public class SettleDispose {

    private State state;

    private SettleParameter settleParameter;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public SettleParameter getSettleParameter() {
        return settleParameter;
    }

    public void setSettleParameter(SettleParameter settleParameter) {
        this.settleParameter = settleParameter;
    }

    public void commit(){
        this.state.disposePay(this.settleParameter);
    }


}
