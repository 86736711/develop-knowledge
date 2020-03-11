package com.npf.knowledge.demo.design.visitor.settle;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.mediator.settle
 * @ClassName: ConcreteSettleServiceBuilder
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 12:48
 * @Version: 1.0
 */
public class ConcreteSettleServiceBuilder implements SettleServiceBuilder,SettleVisitor {

    private SettleElement settleElement;

    public ConcreteSettleServiceBuilder(SettleElement settlementItem){
        this.settleElement = settlementItem;
    }


    @Override
    public void visit(SettleElement element) {

        //我是结算参数处理中介我要处理数据啦
        if(element instanceof SettlementItem){
            System.out.println("我是SettlementItem，做我相应的处理");
        }
    }

    @Override
    public void buildSc() {
        //让中介帮我处理吧
        System.out.println("我本身就是一个中介，结算节点要处理一下数据");
        settleElement.accept(this);
    }
}
