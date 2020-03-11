package com.npf.knowledge.demo.design.build;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.build
 * @ClassName: CarBuilder
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/13 18:37
 * @Version: 1.0
 */
public class CarBuilder {

    private String carColor;

    private String carTyre;


    public static CarBuilder create(){
        return new CarBuilder();
    }

    public CarBuilder setCarColor(String carColor){
        this.carColor = carColor;
        return this;
    }

    public CarBuilder setCarTyre(String carTyre){
        this.carTyre = carTyre;
        return this;
    }


    public ICar build(){

        ICar benCar = new BenCar();
        benCar.carBody(this.carColor,this.carTyre);
        return benCar;
    }


}
