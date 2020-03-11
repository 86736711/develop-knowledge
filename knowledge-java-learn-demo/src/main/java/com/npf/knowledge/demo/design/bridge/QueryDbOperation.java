package com.npf.knowledge.demo.design.bridge;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.bridge
 * @ClassName: QueryDbOperation
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/5 14:36
 * @Version: 1.0
 */
public class QueryDbOperation extends DbOperation {
    public QueryDbOperation(DbConnect dbConnect) {
        super(dbConnect);
    }

    public void dbCheck(){

        dbOpen();

        //检查这个数据库的打开是否正确，例如执行一下查询语句

        dbClose();

    }
}
