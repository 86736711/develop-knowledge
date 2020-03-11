package com.npf.knowledge.demo.design.reactor;

import java.io.IOException;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.reactor
 * @ClassName: ReactorTest
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/15 19:40
 * @Version: 1.0
 */
public class ReactorTest {

    public static void main(String[] args) {

        try {
            new Thread(new Reactor(3333)).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
