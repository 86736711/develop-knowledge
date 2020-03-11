package com.npf.knowledge.demo.design.strategy;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.strategy
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 策略模式的用意就是将一些处理的方式，或者解决问题的模式都抽象化，最后保证新增很多的策略也不会改变主流程的业务
 * @Date: 2020/2/10 11:06
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {


        Person person = new Person(new CarTravelStrategy());

        person.travel();


    }

}
