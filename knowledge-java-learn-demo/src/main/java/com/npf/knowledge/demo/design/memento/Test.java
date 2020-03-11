package com.npf.knowledge.demo.design.memento;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.memento
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 备忘录模式的例子很简单，意思就是可以将一个对象的每一个阶段的内容可以保持起来等待还原，保持可以做成列表这样我就可以还原到随时的一个节点。
 * @Date: 2020/2/9 15:31
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {

        RoleCaretaker roleCaretaker = new PlayerStateCaretaker();

        Player player = new Player();

        //举例这是游戏开始，初始化玩家
        player.setName("小T");
        player.setHealthPoint(100);
        player.setMagicPoint(100);


        //做任务过程中
        player.setHealthPoint(player.getHealthPoint()-10);
        player.setMagicPoint(player.getMagicPoint()-30);


        //存档
        roleCaretaker.saveMemento(player.getPlayerState());


        //我后悔了想重新开始
        player.recoveryState(roleCaretaker.getMemento());
    }
}
