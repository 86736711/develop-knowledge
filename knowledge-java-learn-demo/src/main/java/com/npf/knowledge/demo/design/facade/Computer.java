package com.npf.knowledge.demo.design.facade;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.facade
 * @ClassName: Computer
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/5 17:07
 * @Version: 1.0
 */
public class Computer {

    private CPU cpu;
    private Disk disk;
    private Memory memory;

    public Computer(CPU cpu , Disk disk , Memory memory){
        this.cpu = cpu;
        this.disk = disk;
        this.memory = memory;
    }



    public void start(){
        cpu.start();
        disk.start();
        memory.start();
        System.out.println("Computer is start...");
    }

    public void shutDown(){
        cpu.shutDown();
        disk.shutDown();
        memory.shutDown();
        System.out.println("Computer is shutDown...");
    }


}
