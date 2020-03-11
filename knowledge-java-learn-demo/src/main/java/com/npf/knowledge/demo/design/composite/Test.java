package com.npf.knowledge.demo.design.composite;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.composite
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 组合模式,组合模式营业比较广泛，主要的就是通过组合来实现低耦合和复用
 * 例如：controller service dao中 service也算一种组合的实现，树形接口也算是一种组合模式
 * @Date: 2020/2/5 15:02
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        Cup cup = new CoffeeCup();

        Dish dish = new BeefDish();

        Person cperson = new ChinaPerson(dish,cup);

        Person uperson = new UsaPerson(dish,cup);

        cperson.eat();

        uperson.eat();

    }
}
