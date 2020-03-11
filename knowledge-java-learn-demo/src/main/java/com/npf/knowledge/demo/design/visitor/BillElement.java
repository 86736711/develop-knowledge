package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: BillElement
 * @Author: ningpf
 * @Description: 这个是访问者模式中的访问元素
 * @Date: 2020/2/10 13:56
 * @Version: 1.0
 */
public interface BillElement {

    /**
     * 接收访问者访问的接口
     * @param accountVisitor
     */
    void accept(AccountVisitor accountVisitor);
}
