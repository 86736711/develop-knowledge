package com.npf.knowledge.demo.design.visitor;

import cn.com.tcsl.s1.design.visitor.settle.ConcreteSettleServiceBuilder;
import cn.com.tcsl.s1.design.visitor.settle.SettleServiceBuilder;
import cn.com.tcsl.s1.design.visitor.settle.SettlementItem;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 这个代码样例只是在代码项目有这样实现的。
 * @Date: 2020/2/10 13:52
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {


        AccountBook accountBook = new AccountBook();

        accountBook.addBill(new ConsumeBill("工资",10000));
        accountBook.addBill(new ConsumeBill("物料",60000));

        accountBook.addBill(new IncomeBill("产品收入",200000));
        accountBook.addBill(new IncomeBill("投资收入",80000));


        AccountVisitor boss = new Boss();
        AccountVisitor cpa = new Accountant();

        accountBook.show(boss);
        accountBook.show(cpa);

        int totalConsume = ((Boss) boss).getTotalConsume();
        int totalIncome = ((Boss) boss).getTotalIncome();

        System.out.println("公司的总消费："+totalConsume);
        System.out.println("公司的总收入："+totalIncome);

        SettleServiceBuilder settleServiceBuilder = new ConcreteSettleServiceBuilder(new SettlementItem());

        settleServiceBuilder.buildSc();
    }
}
