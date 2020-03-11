package com.npf.knowledge.demo.design.factory.product;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory.product
 * @ClassName: BmwFactory
 * @Author: ningpf
 * @Description: BMW工厂
 * @Date: 2020/1/13 13:50
 * @Version: 1.0
 */
public class BmwFactory implements IFactory {

    public ICar makeCar() {
        return new BmwCar();
    }

}
