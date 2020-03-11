package com.npf.knowledge.demo.java.thread;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.thread
 * @ClassName: LocalThreadTest
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/3/4 22:30
 * @Version: 1.0
 */
public class LocalThreadTest {


    public static final String[] strs = new String[1024*1024*1024];

    public static ThreadLocal<String> str = new ThreadLocal<>();

    public static ThreadLocal<Integer> ints= new ThreadLocal<>();

    public static void main(String[] args) {

        //str.set("aaa");

        //ints.set(1);



        //System.out.println(str.get());
        //System.out.println(ints.get());


    }


}
