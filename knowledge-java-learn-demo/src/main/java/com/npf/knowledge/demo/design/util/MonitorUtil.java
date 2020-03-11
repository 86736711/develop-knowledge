package com.npf.knowledge.demo.design.util;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.util
 * @ClassName: MonitorUtil
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/16 18:25
 * @Version: 1.0
 */
public class MonitorUtil {

    private static ThreadLocal<Long> tl = new ThreadLocal<Long>();

    public static void start() {
        tl.set(System.currentTimeMillis());
    }

    //结束时打印耗时
    public static void finish(String methodName) {
        long finishTime = System.currentTimeMillis();
        System.out.println(methodName + "方法耗时" + (finishTime - tl.get()) + "ms");
    }
}
