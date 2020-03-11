package com.npf.knowledge.demo.design.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.visitor
 * @ClassName: AccountBook
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/10 15:58
 * @Version: 1.0
 */
public class AccountBook {


    //单子列表
    private List<BillElement> billList = new ArrayList<BillElement>();
    //添加单子
    public void addBill(BillElement bill){
        billList.add(bill);
    }


    //供账本的查看者查看账本
    public void show(AccountVisitor viewer){
        for (BillElement bill : billList) {
            bill.accept(viewer);
        }
    }

}
