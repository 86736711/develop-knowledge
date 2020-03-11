package com.npf.knowledge.demo.java.concurrent;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.concurrent
 * @ClassName: PutMap
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 10:55
 * @Version: 1.0
 */
public class PutMap implements Runnable {
    @Override
    public void run() {
        if(MapTest.concurrentMap.get("name") == null){
            MapTest.concurrentMap.put("name","name");
        }else{
            System.out.println("name 不存在");
        }
    }
}
