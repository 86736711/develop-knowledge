package com.npf.knowledge.demo.design.composite;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.composite
 * @ClassName: CoffeeCup
 * @Author: ningpf
 * @Description: 咖啡杯子
 * @Date: 2020/2/5 15:18
 * @Version: 1.0
 */
public class CoffeeCup implements Cup{


    public void drink() {
        System.out.println("咖啡好喝吧");
    }
}
