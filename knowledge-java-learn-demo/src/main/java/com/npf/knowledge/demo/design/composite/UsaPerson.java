package com.npf.knowledge.demo.design.composite;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.composite
 * @ClassName: UsaPerson
 * @Author: ningpf
 * @Description: 美国人,先吃饭在和饮品，这个组合是随意的
 * @Date: 2020/2/5 14:51
 * @Version: 1.0
 */
public class UsaPerson implements Person{

    private Cup cup;

    private Dish dish;

    public UsaPerson(Dish dish,Cup cup){
        this.dish = dish;

        this.cup = cup;
    }


    public void eat() {


        dish.eat();

        cup.drink();

    }
}
