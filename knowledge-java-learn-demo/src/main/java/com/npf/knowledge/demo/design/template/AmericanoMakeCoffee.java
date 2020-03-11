package com.npf.knowledge.demo.design.template;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.template
 * @ClassName: AmericanoMakeCoffee
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 11:35
 * @Version: 1.0
 */
public class AmericanoMakeCoffee extends AbsMakeCoffee {
    @Override
    public void addCondiments() {
        System.out.println("美式咖啡啥也不用加");
    }
}
