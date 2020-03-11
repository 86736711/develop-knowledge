package com.npf.knowledge.demo.design.build;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.build
 * @ClassName: BenCar
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/13 18:32
 * @Version: 1.0
 */
public class BenCar implements ICar{

    private String color;

    private String tyre;

    public String carBody(String color, String tyre) {
        this.color = color;
        this.tyre = tyre;

        StringBuffer returnStr = new StringBuffer();
        returnStr.append("this is ")
                .append(color)
                .append("car have ")
                .append(tyre);

        return returnStr.toString();
    }

    public void carMoving() {

        System.out.println("this is " + color + "car!moving!");
    }

    public void carStop() {

        System.out.println("this is " + color + "car!stop!");
    }
}
