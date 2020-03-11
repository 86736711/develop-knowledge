package com.npf.knowledge.demo.design.flyweight;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.flyweight
 * @ClassName: TakeOutFlyWeight
 * @Author: ningpf
 * @Description: 处理外卖数据的实现类
 * @Date: 2020/2/5 17:33
 * @Version: 1.0
 */
public class TakeOutFlyWeight implements FlyWeight {

    private String name;

    public TakeOutFlyWeight(String name){
        this.name = name;
    }


    public void action(String data) {
        System.out.println("处理器："+name+"，外卖的数据处理");
    }
}
