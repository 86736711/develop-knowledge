package com.npf.knowledge.demo.design.mediator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator
 * @ClassName: Test
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/7 15:47
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {

        MediatorTask mediatorTask = new PayData("62725",new DataMediator());

        //普通访问
        mediatorTask.dispose();

        //中介访问
        mediatorTask.disposeMediator();






    }
}
