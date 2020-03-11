package com.npf.knowledge.demo.design.mediator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator
 * @ClassName: DataMediator
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/7 14:33
 * @Version: 1.0
 */
public class DataMediator implements Mediator {


    @Override
    public void contact(String data,MediatorTask mediatorTask) {

        if(mediatorTask instanceof PayData){
            PayData payData = (PayData)mediatorTask;

            data = "12345";

            //我是中介我可以把帮你处理一下你想要的数据
            System.out.println("我是中介我可以把帮你处理一下你想要的数据data ->"+data);

            payData.dispose();
        }


    }
}
