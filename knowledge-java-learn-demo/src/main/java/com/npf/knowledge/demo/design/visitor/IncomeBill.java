package com.npf.knowledge.demo.design.visitor;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: IncomeBill
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 14:42
 * @Version: 1.0
 */
public class IncomeBill implements BillElement{

    private int amount;

    private String item;

    public IncomeBill(String item,int amount){
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
