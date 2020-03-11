package com.npf.knowledge.demo.design.bridge;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.bridge
 * @ClassName: DbOperation
 * @Author: ningpf
 * @Description: 数据库的操作，这个就是桥接的点，这个类可以进行扩展并且不用关心是什么类型的数据库，这样将操作和数据库连接进行了解耦，在扩展的时候只需要关心自己的职责可以
 * 在很多的地方都有桥接的思想，例如Windows的api就是 硬件和软件之间的桥接接口。 例如外卖的服务就是订单系统和外卖平台桥接。代码的设计模式都可以上升都服务，下沉到硬件
 * @Date: 2020/2/5 14:28
 * @Version: 1.0
 */
public class DbOperation {
    private DbConnect dbConnect;

    public DbOperation(DbConnect dbConnect){
        this.dbConnect = dbConnect;
    }

    public void dbOpen(){
        //可以做一些操作，例如记录连接时间，连接异常的操作等等
        dbConnect.connect();
    }

    public void dbClose(){
        dbConnect.close();
    }

}
