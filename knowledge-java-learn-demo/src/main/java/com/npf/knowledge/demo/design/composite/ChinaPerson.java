package com.npf.knowledge.demo.design.composite;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.composite
 * @ClassName: ChinaPerson
 * @Author: ningpf
 * @Description: 中国人，先喝饮品在吃饭，这个组合是随意的
 * @Date: 2020/2/5 14:50
 * @Version: 1.0
 */
public class ChinaPerson implements Person{

    private Cup cup;

    private Dish dish;

    public ChinaPerson(Dish dish,Cup cup){
        this.dish = dish;

        this.cup = cup;
    }


    public void eat() {

        cup.drink();

        dish.eat();

    }
}
