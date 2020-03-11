package com.npf.knowledge.demo.design.strategy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.strategy
 * @ClassName: TrainTravelStrategy
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:05
 * @Version: 1.0
 */
public class TrainTravelStrategy implements TravelStrategy {
    @Override
    public void travelStyle() {
        System.out.println("我要坐火车环游世界");
    }
}
