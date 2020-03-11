package com.npf.knowledge.demo.design.factory.product;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory.product
 * @ClassName: BenFactory
 * @Author: ningpf
 * @Description: ben工厂
 * @Date: 2020/1/13 13:48
 * @Version: 1.0
 */
public class BenFactory implements IFactory {

    public ICar makeCar() {
        return new BenCar();
    }

}
