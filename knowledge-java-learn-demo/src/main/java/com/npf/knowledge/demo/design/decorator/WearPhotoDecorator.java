package com.npf.knowledge.demo.design.decorator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.decorator
 * @ClassName: WearDecorator
 * @Author: ningpf
 * @Description: 穿上衣服吃什么饭呀当然是照个相了
 * @Date: 2020/2/5 16:38
 * @Version: 1.0
 */
public class WearPhotoDecorator implements Decorator{

    private People people;

    public WearPhotoDecorator(People people){
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
        System.out.println("穿的这么好看照个相吧");
    }
}
