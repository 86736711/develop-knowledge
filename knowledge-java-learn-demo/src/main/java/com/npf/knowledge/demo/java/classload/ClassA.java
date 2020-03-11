package com.npf.knowledge.demo.java.classload;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.classload
 * @ClassName: ClassA
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/15 14:21
 * @Version: 1.0
 */
public class ClassA {

    private String name;

    static{
        System.out.println("初始化加载！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
