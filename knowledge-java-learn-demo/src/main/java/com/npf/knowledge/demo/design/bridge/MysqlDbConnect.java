package com.npf.knowledge.demo.design.bridge;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.bridge
 * @ClassName: MysqlDbConnect
 * @Author: ningpf
 * @Description: mysql的数据库实现
 * @Date: 2020/2/5 14:23
 * @Version: 1.0
 */
public class MysqlDbConnect {

    public void connect() {
        System.out.println("mysql connected");
    }

    public void close() {
        System.out.println("mysql closed");
    }

}
