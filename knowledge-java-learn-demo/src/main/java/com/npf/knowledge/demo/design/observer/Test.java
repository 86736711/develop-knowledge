package com.npf.knowledge.demo.design.observer;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.observer
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 观察者模式需要顶一个观察人员来同通知对这个消息感兴趣的人，这个模式被广泛的营业，在接收消息后处理可以试异步的提高效率
 * @Date: 2020/2/9 16:07
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {



        MesObserver mesObserverA = new MesObserver("小明");
        MesObserver mesObserverB = new MesObserver("小刚");

        MessageObservable messageObservable = new MessageObservable();

        messageObservable.addObserver(mesObserverA);
        messageObservable.addObserver(mesObserverB);


        messageObservable.hasMessage("吃饭了");
    }

}
