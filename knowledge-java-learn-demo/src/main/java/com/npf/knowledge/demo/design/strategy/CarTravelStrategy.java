package com.npf.knowledge.demo.design.strategy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.strategy
 * @ClassName: CarTravelStrategy
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:04
 * @Version: 1.0
 */
public class CarTravelStrategy implements TravelStrategy {
    @Override
    public void travelStyle() {
        System.out.println("我要开着汽车环游世界");
    }
}
