package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: Boss
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 15:22
 * @Version: 1.0
 */
public class Boss implements AccountVisitor {


    private int totalConsume;

    private int totalIncome;


    public void visitor(ConsumeBill consumeBill) {
        totalConsume += consumeBill.getAmount();
    }

    public void visitor(IncomeBill incomeBill) {

        totalIncome += incomeBill.getAmount();
    }

    public int getTotalConsume() {
        return totalConsume;
    }

    public int getTotalIncome() {
        return totalIncome;
    }
}