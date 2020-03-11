package com.npf.knowledge.demo.design.template;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.template
 * @ClassName: LatteMakeCoffee
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:36
 * @Version: 1.0
 */
public class LatteMakeCoffee extends AbsMakeCoffee {
    @Override
    public void addCondiments() {
        System.out.println("加点牛奶吧走一个拿铁咖啡");
    }
}
