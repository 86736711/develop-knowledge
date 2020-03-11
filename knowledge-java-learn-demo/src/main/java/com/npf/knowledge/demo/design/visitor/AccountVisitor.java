package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: AccountVisitor
 * @Author: ningpf
 * @Description: 这是账户的访问者
 * @Date: 2020/2/10 13:59
 * @Version: 1.0
 */
public interface AccountVisitor {

    void visitor(ConsumeBill consumeBill);

    void visitor(IncomeBill incomeBill);
}
