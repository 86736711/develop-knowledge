package com.npf.knowledge.demo.design.factory.product;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory.product
 * @ClassName: SimpleFactory
 * @Author: ningpf
 * @Description: 简单工程模式，每个模式没有好坏，要看是否适合这个阶段。这个从代码上看耦合了创建路径的过程。每次扩展都会修改这个代码。并且在使用还需要记住类型串
 * @Date: 2020/1/13 11:58
 * @Version: 1.0
 */
public class SimpleFactory {


    public ICar makeCar(String carBrand){
        if("Ben".equals(carBrand)){
            return new BenCar();
        }else if("Bmw".equals(carBrand)){
            return new BmwCar();
        }
        return null;
    }

}
