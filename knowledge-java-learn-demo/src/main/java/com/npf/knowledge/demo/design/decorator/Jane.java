package com.npf.knowledge.demo.design.decorator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.decorator
 * @ClassName: Jane
 * @Author: ningpf
 * @Description: Jane穿上了一个西装
 * @Date: 2020/2/5 16:37
 * @Version: 1.0
 */
public class Jane implements People {
    public void wear() {
        System.out.println("穿上西装");
    }
}
