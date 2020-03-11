package com.npf.knowledge.demo.arithmetic;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.arithmetic
 * @ClassName: ShellSort
 * @Author: ningpf
 * @Description: 希尔排序也算是一种插入排序，但是在之前做了一些出里，将已有的数组进行一个逻辑分组这个逻辑分组的组数也是数组中每个
 * 节点相邻的间隔数，并且在做每次分组就进行下一次分组，例如4/2/1，知道整个数组有序，人后在对逻辑分组进行排序，
 * @Date: 2020/3/10 17:21
 * @Version: 1.0
 */
public class ShellSort {

    public static void main(String[] args)
    {
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        // 希尔排序
        int d = a.length;
        while (true)
        {
            //这就是每次分组的值
            d = d / 2;
            for (int x = 0; x < d; x++)
            {
                for (int i = x + d; i < a.length; i = i + d)
                {
                    int temp = a[i];
                    int j;
                    for (j = i - d; j >= 0 && a[j] > temp; j = j - d)
                    {
                        a[j + d] = a[j];
                    }
                    a[j + d] = temp;
                }
            }
            if (d == 1)
            {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }

    }


}
