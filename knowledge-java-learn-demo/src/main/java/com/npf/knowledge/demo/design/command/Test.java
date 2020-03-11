package com.npf.knowledge.demo.design.command;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: Test
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 15:51
 * @Version: 1.0
 */
public class Test {

    /*
    命令模式：是对外界开发一些命令来使用内部的功能，而内部是通过命令来扩展提供的功能，实现的开闭原则
    在这里就不代码来实现了，只是举例：想restful的api接口就是一种命令的模式。像linux系统有很多的
    系统命令也是命令的模式来解决扩展的问题。
    想来想去还是写一个DEMO吧
     */

    public static void main(String[] args) {

        Command command = new Command();

        command.exeCommand(CommandConstant.OPEN);
        command.exeCommand(CommandConstant.CLOSE);
    }
}
