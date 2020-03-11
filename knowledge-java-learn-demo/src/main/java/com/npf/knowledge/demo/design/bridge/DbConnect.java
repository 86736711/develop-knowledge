package com.npf.knowledge.demo.design.bridge;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.bridge
 * @ClassName: DbConnect
 * @Author: ningpf
 * @Description: 定义了标准的数据库连接的接口
 * @Date: 2020/2/5 14:21
 * @Version: 1.0
 */
public interface DbConnect {

    void connect();

    void close();

}
