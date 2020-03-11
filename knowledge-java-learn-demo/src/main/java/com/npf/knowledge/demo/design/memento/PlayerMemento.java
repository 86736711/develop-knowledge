package com.npf.knowledge.demo.design.memento;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.memento
 * @ClassName: PlayerMemento
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 15:18
 * @Version: 1.0
 */
public class PlayerMemento {

    private int healthPoint;

    private int magicPoint;

    public PlayerMemento(int healthPoint,int magicPoint){
        this.healthPoint = healthPoint;

        this.magicPoint = magicPoint;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public int getMagicPoint() {
        return magicPoint;
    }

    public void setMagicPoint(int magicPoint) {
        this.magicPoint = magicPoint;
    }
}
