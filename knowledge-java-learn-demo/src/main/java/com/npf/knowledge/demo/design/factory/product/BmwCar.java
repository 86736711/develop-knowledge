package com.npf.knowledge.demo.design.factory.product;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory.product
 * @ClassName: BmwCar
 * @Author: ningpf
 * @Description: bmw车
 * @Date: 2020/1/13 11:57
 * @Version: 1.0
 */
public class BmwCar implements ICar {
    public String getBrand() {
        return "BMW";
    }

    public void driverCar() {
        System.out.println("this is a "+getBrand()+" car");
    }
}
