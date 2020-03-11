package com.npf.knowledge.demo.design.iterator;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.iterator
 * @ClassName: Dispose
 * @Author: ningpf
 * @Description: 定义处理器的标准
 * @Date: 2020/2/7 11:01
 * @Version: 1.0
 */
public interface Dispose extends Comparable<Dispose> {

    /**
     * 这里定义的返回数值代表了执行的顺序，数越小越靠前执行
     * @return serialNumber
     */
    public int getExeSerialNumber();

    /**
     * 处理器要处理的数据
     * @param data 被处理的数据
     * @return 是否处理成功，不会返回null
     */
    public boolean disposeDate(String data);

    //继承Comparable接口，这个接口就是可由比较的能力，其实和自己能以api的行为是一样的
    default int compareTo(Dispose o){

        if(getExeSerialNumber() >= o.getExeSerialNumber()){

            return 1;
        }else{
            return -1;
        }

    }
}
