package com.npf.knowledge.demo.design.command;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.command
 * @ClassName: CommandConstant
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 15:56
 * @Version: 1.0
 */
public class CommandConstant {

    public static final String OPEN = "open";

    public static final String QUERY = "query";

    public static final String CLOSE = "close";

    public static final String HELP = "help";

    public static String help(){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open command is open file")
                .append("query command is query file")
                .append("close command is close file");

        return stringBuffer.toString();
    }


}
