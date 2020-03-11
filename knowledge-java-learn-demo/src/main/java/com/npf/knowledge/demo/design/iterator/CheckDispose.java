package com.npf.knowledge.demo.design.iterator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: CheckDispose
 * @Author: ningpf
 * @Description: 数据校验
 * @Date: 2020/2/7 11:04
 * @Version: 1.0
 */
public class CheckDispose implements Dispose {

    @Override
    public int getExeSerialNumber() {
        return 1;
    }

    public boolean disposeDate(String data) {
        System.out.println("check data");
        if(data == null)
            return false;
        else
            return true;
    }
}
