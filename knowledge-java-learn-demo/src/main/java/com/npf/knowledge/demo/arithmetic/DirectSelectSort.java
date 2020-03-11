package com.npf.knowledge.demo.arithmetic;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.arithmetic
 * @ClassName: DirectSelectSort
 * @Author: ningpf
 * @Description: 选择排序，主要思想就是每次都遍历一遍找到最小值然后插入到数组的头部的下一个节点，知道最后完成排序
 * @Date: 2020/3/10 17:38
 * @Version: 1.0
 */
public class DirectSelectSort {


    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // 直接选择排序
        for (int i = 0; i < a.length; i++)
        {
            int min = a[i];
            int n = i; // 最小数的索引
            for (int j = i + 1; j < a.length; j++)
            {
                if (a[j] < min)
                { // 找出最小的数
                    min = a[j];
                    n = j;
                }
            }
            a[n] = a[i];
            a[i] = min;

        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }

}
