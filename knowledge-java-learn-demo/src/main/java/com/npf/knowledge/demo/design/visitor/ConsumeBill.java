package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: ConsumeBill
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 14:03
 * @Version: 1.0
 */
public class ConsumeBill implements BillElement {

    private int amount;

    private String item;


    public ConsumeBill(String item,int amount){
        this.amount = amount;
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void accept(AccountVisitor visitor) {
        visitor.visitor(this);
    }
}
