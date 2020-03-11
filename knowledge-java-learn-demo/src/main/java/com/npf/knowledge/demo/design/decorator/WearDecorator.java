package com.npf.knowledge.demo.design.decorator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.decorator
 * @ClassName: WearDecorator
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/5 16:38
 * @Version: 1.0
 */
public class WearDecorator implements Decorator{

    private People people;

    public WearDecorator(People people){
        this.people = people;
    }


    public void wear() {
        wearBefore();
        people.wear();
        wearAfter();
    }

    public void wearBefore() {
        System.out.println("先洗个澡");
    }

    public void wearAfter() {
        System.out.println("吃个早点");
    }
}
