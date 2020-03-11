package com.npf.knowledge.demo.design.observer;


import java.util.Observable;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.observer
 * @ClassName: MessageObservable
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 15:50
 * @Version: 1.0
 */
public class MessageObservable extends Observable {


    public void hasMessage(String mes){
        setChanged();
        notifyObservers(mes);
    }

}
