package com.npf.knowledge.demo.design.memento;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.memento
 * @ClassName: RoleCaretaker
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/9 15:28
 * @Version: 1.0
 */
public interface RoleCaretaker {


    void saveMemento(PlayerMemento playerMemento);

    PlayerMemento getMemento();
}
