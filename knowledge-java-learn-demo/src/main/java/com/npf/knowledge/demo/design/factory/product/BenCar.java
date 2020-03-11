package com.npf.knowledge.demo.design.factory.product;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory.product
 * @ClassName: BenCar
 * @Author: ningpf
 * @Description: ben车
 * @Date: 2020/1/13 11:55
 * @Version: 1.0
 */
public class BenCar implements ICar {
    public String getBrand() {
        return "Ben";
    }

    public void driverCar() {
        System.out.println("this is a "+getBrand()+" car");
    }
}
