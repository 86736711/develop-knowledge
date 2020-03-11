package com.npf.knowledge.demo.java.cpu;

public class CpuDemo {

    static final int MAXIMUM_CAPACITY = 1 << 30;


    static final int tableSizeFor(int cap) {
        int n = cap - 1; //1100   //1011
        n |= n >>> 1;             //0101 //1111
        n |= n >>> 2;                    //0011 //1111
        n |= n >>> 4;                           //0000 //1111
        n |= n >>> 8;                                  //0000 //1111
        n |= n >>> 16;                                        //0000 //1111
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {

        System.out.println(tableSizeFor(33));

        /*
        CpuDemo cpuDemo = new CpuDemo();
        cpuDemo.testCpu();
        */
    }

    /**
     * 这种很多数据的循环，会引起CPU的瞬间增高，增加循环睡眠的时间会降低CPU升高的最高值
     * 根据业务一定要尽量注意不要做很多数据的循环处理
     */
    public void testCpu(){

        for (int i=0; i<6000 ; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
