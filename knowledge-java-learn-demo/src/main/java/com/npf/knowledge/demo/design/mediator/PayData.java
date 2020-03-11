package com.npf.knowledge.demo.design.mediator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator
 * @ClassName: PayData
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/7 14:32
 * @Version: 1.0
 */
public class PayData implements MediatorTask {

    private Mediator mediator;
    private String data;

    public PayData(String data,Mediator mediator){
        this.mediator = mediator;
        this.data = data;
    }

    @Override
    public void dispose() {
        System.out.println("data->"+data);
        System.out.println("我把数据处理完了");
    }

    @Override
    public void disposeMediator() {
        mediator.contact(data,this);
    }
}
