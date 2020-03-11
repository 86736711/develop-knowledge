package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: Accountant
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 15:31
 * @Version: 1.0
 */
public class Accountant implements AccountVisitor {


    public void visitor(ConsumeBill consumeBill) {

        System.out.println("消费项:"+consumeBill.getItem()+",记账:"+consumeBill.getAmount());
    }

    public void visitor(IncomeBill incomeBill) {

        System.out.println("收入项:"+incomeBill.getItem()+",报税:"+incomeBill.getAmount());
    }
}
