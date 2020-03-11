package com.npf.knowledge.demo.design.iterator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: PrintDispose
 * @Author: ningpf
 * @Description: 数据打印
 * @Date: 2020/2/7 11:02
 * @Version: 1.0
 */
public class PrintDispose implements Dispose {


    @Override
    public int getExeSerialNumber() {
        return 0;
    }

    public boolean disposeDate(String data) {
        System.out.println("print data->"+data);
        return true;
    }
}
