package com.npf.knowledge.demo.design.template;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.template
 * @ClassName: AbsMakeCoffee
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:32
 * @Version: 1.0
 */
public abstract class AbsMakeCoffee implements Condiments {



    public final void makeCoffee(){
        //步骤一 将水煮沸
        boilWater();
        //步骤二 将饮料倒入杯中
        pourInCup();
        //步骤三 加入调味料
        addCondiments();
    }


    /**
     * 基本方法，将水煮沸 这对所有子类而言是一个共同的行为，所以声明为private,无需向子类开放
     */
    private void boilWater(){
        System.out.println("将水煮沸");
    }


    private void pourInCup(){
        System.out.println("将饮料倒入杯中");
    }


}
