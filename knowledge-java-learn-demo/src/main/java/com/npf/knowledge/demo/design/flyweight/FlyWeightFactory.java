package com.npf.knowledge.demo.design.flyweight;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.flyweight
 * @ClassName: FlyWeightFactory
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/5 17:34
 * @Version: 1.0
 */
public class FlyWeightFactory {

    private static ConcurrentHashMap<String, FlyWeight> allFlyWeight = new ConcurrentHashMap<String, FlyWeight>();

    public FlyWeight getFlyWeight(String name){
        if(allFlyWeight.containsKey(name)){
            return allFlyWeight.get(name);
        }else{
            return allFlyWeight.put(name,new TakeOutFlyWeight(name));
        }
    }
}
