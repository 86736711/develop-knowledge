package com.npf.knowledge.demo.design.command;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: Open
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 16:01
 * @Version: 1.0
 */
public class Open implements Task{

    public void openFile(){
        System.out.println("我打开了文件");
    }

    public String getCommand() {
        return CommandConstant.OPEN;
    }

    public void exeCommand() {
        openFile();
    }
}
