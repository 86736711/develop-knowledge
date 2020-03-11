package com.npf.knowledge.demo.java.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.concurrent
 * @ClassName: MapTest
 * @Author: ningpf
 * @Description: 这是一个concurrentMap的测试，主要的目的是明确get是同步的方法，同步的方式在1.8以后使用了Volatile的JNI的本地方法。
 * @Date: 2020/2/6 10:48
 * @Version: 1.0
 */
public class MapTest {

    public static ConcurrentMap<String,String> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        for (int i=0; i<15 ;i++){
            new Thread(new PutMap()).start();
        }
    }


}
