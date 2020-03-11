package com.npf.knowledge.demo.design.factory;

import cn.com.tcsl.s1.design.factory.product.*;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.factory
 * @ClassName: FactoryTest
 * @Author: ningpf
 * @Description: 工厂模式的执行主体
 * @Date: 2020/1/13 11:51
 * @Version: 1.0
 */
public class FactoryTest {


    public static void main(String[] args) {

        //简单工程模式
        SimpleFactory simpleFactory = new SimpleFactory();
        ICar car = simpleFactory.makeCar("Ben");
        car.driverCar();


        //抽象工厂模式
        IFactory benFactory = new BenFactory();
        ICar benCar = benFactory.makeCar();
        benCar.driverCar();

        IFactory bmwFactory = new BmwFactory();
        ICar bmwCar = bmwFactory.makeCar();
        bmwCar.driverCar();



    }


}
