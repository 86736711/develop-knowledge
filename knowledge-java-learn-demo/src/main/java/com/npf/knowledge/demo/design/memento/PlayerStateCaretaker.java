package com.npf.knowledge.demo.design.memento;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.memento
 * @ClassName: PlayerStateCaretaker
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 15:30
 * @Version: 1.0
 */
public class PlayerStateCaretaker implements RoleCaretaker {

    private PlayerMemento playerMemento;


    @Override
    public void saveMemento(PlayerMemento playerMemento) {
        this.playerMemento = playerMemento;
    }

    @Override
    public PlayerMemento getMemento() {

        return this.playerMemento;
    }
}
