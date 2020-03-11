package com.npf.knowledge.demo.design.decorator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.decorator
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 通过这样的装饰可以自由的扩展对于穿衣服这个流程的各种业务操作
 * @Date: 2020/2/5 16:49
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        People people = new Jane();

        People eatPeople = new WearDecorator(people);

        People photoPeople = new WearDecorator(people);


        people.wear();

        eatPeople.wear();

        photoPeople.wear();
    }
}
