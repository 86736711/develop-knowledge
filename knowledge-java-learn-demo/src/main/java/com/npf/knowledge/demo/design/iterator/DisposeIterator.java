package com.npf.knowledge.demo.design.iterator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: DisposeIterator
 * @Author: ningpf
 * @Description: 定义迭代器的标准
 * @Date: 2020/2/7 10:59
 * @Version: 1.0
 */
public interface DisposeIterator {

    public void addDispose(Dispose dispose);

    public void sort();

    public void disposeIterator(String data);

}
