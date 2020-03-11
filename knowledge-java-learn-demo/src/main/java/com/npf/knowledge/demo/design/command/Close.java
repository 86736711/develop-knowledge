package com.npf.knowledge.demo.design.command;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: Close
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 16:01
 * @Version: 1.0
 */
public class Close  implements Task{

    public void closeFile(){
        System.out.println("我关闭了文件");
    }

    public String getCommand() {
        return CommandConstant.CLOSE;
    }

    public void exeCommand() {
        closeFile();
    }
}
