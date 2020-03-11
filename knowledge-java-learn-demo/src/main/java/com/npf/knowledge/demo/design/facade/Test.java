package com.npf.knowledge.demo.design.facade;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.facade
 * @ClassName: Test
 * @Author: ningpf
 * @Description: facade模式的核心思想就是给外部暴露统一的接口，或者统一的使用api
 * @Date: 2020/2/5 17:09
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {
        Computer computer = new Computer(new CPU(),new Disk(),new Memory());
        computer.start();
        computer.shutDown();
    }
}
