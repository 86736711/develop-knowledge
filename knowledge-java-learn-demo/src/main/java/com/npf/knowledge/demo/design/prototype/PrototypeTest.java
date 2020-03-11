package com.npf.knowledge.demo.design.prototype;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.prototype
 * @ClassName: PrototypeTest
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/13 19:03
 * @Version: 1.0
 */
public class PrototypeTest {

    public static void main(String[] args) {

        ProtoBean protoBean = new ProtoBean();
        protoBean.setName("小明");
        protoBean.setAddress("天津市");

        ProtoBean clone = (ProtoBean)protoBean.clone();
        clone.setAddress("北京市");
        System.out.println("protoBean - >"+protoBean.getAddress()+"clone - >"+clone.getAddress());

    }
}
