package com.npf.knowledge.demo.design.build;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.build
 * @ClassName: BuilderTest
 * @Author: ningpf
 * @Description: 构建者模式，将实体实例化的过车封闭起来，让外部调用很简单，这个最终的构建过程也可以开放成接口，根据实际的需求来判定
 * @Date: 2020/1/13 18:26
 * @Version: 1.0
 */
public class BuilderTest {

    public static void main(String[] args) {
        //单独准备构建者的模式
        CarBuilder carBuilder = CarBuilder.create();
        carBuilder.setCarColor("red");
        carBuilder.setCarTyre("big");
        ICar redCar = carBuilder.build();
        redCar.carMoving();


        carBuilder.setCarColor("green");
        carBuilder.setCarTyre("big");
        ICar greenCar = carBuilder.build();
        greenCar.carMoving();


        //自带构建者的模式
        BmwCar.Builder builder = new BmwCar.Builder();
        builder.setCarColor("black");
        builder.setCarTyre("big");
        ICar blackCar = builder.build();
        blackCar.carMoving();

    }

}
