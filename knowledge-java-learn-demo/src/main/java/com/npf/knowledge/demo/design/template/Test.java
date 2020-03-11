package com.npf.knowledge.demo.design.template;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.template
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 模板方法的主要模式是将只做的过程封闭起来，这样每一杯的咖啡都是标准流程出来的绝对没有问题。再讲可以加料的接口开放出去，这样可以扩展出很多样式的咖啡。
 * @Date: 2020/2/10 11:36
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {

        AbsMakeCoffee amer = new AmericanoMakeCoffee();

        amer.makeCoffee();

        amer = new LatteMakeCoffee();

        amer.makeCoffee();;


    }
}
