package com.npf.knowledge.demo.design.iterator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: Test
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/7 11:01
 * @Version: 1.0
 */
public class Test {


    public static void main(String[] args) {


        DisposeIterator disposeIterator = new DataDisposeIterator();
        disposeIterator.addDispose(new CheckDispose());
        disposeIterator.addDispose(new PrintDispose());


        disposeIterator.disposeIterator("data");

    }
}
