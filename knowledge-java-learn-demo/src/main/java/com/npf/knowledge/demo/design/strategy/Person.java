package com.npf.knowledge.demo.design.strategy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.strategy
 * @ClassName: Person
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:08
 * @Version: 1.0
 */
public class Person {

    private TravelStrategy strategy;

    public Person(TravelStrategy strategy){
        this.strategy = strategy;
    }


    public void travel(){

        System.out.println("我要去旅游了怎么去呢");

        strategy.travelStyle();

    }
}
