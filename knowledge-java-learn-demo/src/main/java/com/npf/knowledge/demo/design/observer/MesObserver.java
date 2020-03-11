package com.npf.knowledge.demo.design.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.observer
 * @ClassName: MesObserver
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 16:04
 * @Version: 1.0
 */
public class MesObserver implements Observer {

    private String name;

    public MesObserver(String name){
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("接受者:"+this.name+"接到:"+o.getClass()+" 的消息："+arg);
    }
}
