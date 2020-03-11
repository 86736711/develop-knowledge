package com.npf.knowledge.demo.design.prototype;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.prototype
 * @ClassName: ProtoBean
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/1/13 19:04
 * @Version: 1.0
 */
public class ProtoBean implements Cloneable{
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object clone()
    {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return object;
    }


}
