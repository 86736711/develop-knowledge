package com.npf.knowledge.demo.design.memento;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.memento
 * @ClassName: Player
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 15:18
 * @Version: 1.0
 */
public class Player {

    private String name;

    private int healthPoint;

    private int magicPoint;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PlayerMemento getPlayerState(){

        return new PlayerMemento(healthPoint,magicPoint);

    };


    public void recoveryState(PlayerMemento playerMemento){
        this.healthPoint = playerMemento.getHealthPoint();
        this.magicPoint = playerMemento.getMagicPoint();
    }
}
