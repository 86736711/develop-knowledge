package com.npf.knowledge.demo.design.command;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: Query
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 16:01
 * @Version: 1.0
 */
public class Query implements Task{

    public void queryFile(){
        System.out.println("我查询了文件");
    }

    public String getCommand() {
        return CommandConstant.QUERY;
    }

    public void exeCommand() {
        queryFile();
    }
}
