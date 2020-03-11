package com.npf.knowledge.demo.design.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: Command
 * @Author: ningpf
 * @Description: 想了想还是做个DEMO来体现命令模式
 * @Date: 2020/2/6 15:55
 * @Version: 1.0
 */
public class Command {


    private Map<String,Task> taskMap = new HashMap<String, Task>();


    public Command(){

        Task open = new Open();
        Task query = new Query();
        Task close = new Close();

        taskMap.put(open.getCommand(),open);
        taskMap.put(query.getCommand(),query);
        taskMap.put(close.getCommand(),close);


    }


    public void exeCommand(String comm){
        taskMap.get(comm).exeCommand();
    }

}
