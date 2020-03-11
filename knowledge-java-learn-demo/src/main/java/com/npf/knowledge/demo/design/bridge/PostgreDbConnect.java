package com.npf.knowledge.demo.design.bridge;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.bridge
 * @ClassName: PostgreDbConnect
 * @Author: ningpf
 * @Description: pg的数据库实现
 * @Date: 2020/2/5 14:24
 * @Version: 1.0
 */
public class PostgreDbConnect implements DbConnect {
    public void connect() {
        System.out.println("pg connected");
    }

    public void close() {
        System.out.println("pg closed");
    }
}
