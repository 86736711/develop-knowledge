package com.npf.knowledge.demo.java.classload;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.java.classload
 * @ClassName: ClassLoaderTest
 * @Author: ningpf
 * @Description: classloader加载测试
 * @Date: 2020/1/15 14:16
 * @Version: 1.0
 */
public class ClassLoaderTest {

    static int test = 6;

    static {
        test += 9;
    }



    static class Singleton{
        private static Singleton singleton = new Singleton();
        public static int value1;
        public static int value2 = 0;

        private Singleton(){
            value1++;
            value2++;
        }

        public static Singleton getInstance(){
            return singleton;
        }

    }

    static class Singleton2{
        public static int value1;
        public static int value2 = 0;
        private static Singleton2 singleton2 = new Singleton2();

        private Singleton2(){
            value1++;
            value2++;
        }

        public static Singleton2 getInstance2(){
            return singleton2;
        }

    }


    public static void main(String[] args) {

        List<ClassA> alist = new ArrayList<>();

        ClassA a = new ClassA();
        a.setName("xiaom");

        alist.add(a);
        alist.add(a);
        alist.add(a);


        System.out.println(a);
        System.out.println(alist);
        System.out.println(alist.toString());

        System.out.println(test);

        /*
        * 1 首先执行main中的Singleton singleton = Singleton.getInstance();
        2 类的加载：加载类Singleton
        3 类的验证
        4 类的准备：为静态变量分配内存，设置默认值。这里为singleton(引用类型)设置为null,value1,value2（基本数据类型）设置默认值0
        5 类的初始化（按照赋值语句进行修改）：
        执行private static Singleton singleton = new Singleton();
        执行Singleton的构造器：value1++;value2++; 此时value1，value2均等于1
        执行
        public static int value1;
        public static int value2 = 0;
        此时value1=1，value2=0
        * */

        Singleton singleton = Singleton.getInstance();
        System.out.println("Singleton1 value1:" + singleton.value1);
        System.out.println("Singleton1 value2:" + singleton.value2);

        /*
        * 1 首先执行main中的Singleton2 singleton2 = Singleton2.getInstance2();
        2 类的加载：加载类Singleton2
        3 类的验证
        4 类的准备：为静态变量分配内存，设置默认值。这里为value1,value2（基本数据类型）设置默认值0,singleton2(引用类型)设置为null,
        5 类的初始化（按照赋值语句进行修改）：
        执行
        public static int value2 = 0;
        此时value2=0(value1不变，依然是0);
        执行
        private static Singleton singleton = new Singleton();
        执行Singleton2的构造器：value1++;value2++;
        此时value1，value2均等于1,即为最后结果
        */

        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);



        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader.getClass());
        System.out.println(classLoader.getParent().getClass());
        System.out.println(classLoader.getParent().getParent());

        /*
        try {
            //只是装载不初始化
            //classLoader.loadClass("cn.com.tcsl.s1.java.classload.ClassA");

            //装载并初始化
            //Class.forName("cn.com.tcsl.s1.java.classload.ClassA");

            //只是装载不初始化，通过第二个参数控制是否初始化
            Class.forName("cn.com.tcsl.s1.java.classload.ClassA",false,classLoader);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */


        MyClassLoader myClassLoader = new MyClassLoader("D:\\workspace\\s1new_workspace\\tcsl-smart-demo\\tcsl-smart-java-demo\\target\\classes\\cn\\com\\tcsl\\s1\\java\\classload");
        try {
            Class<?> aClass = myClassLoader.findClass("cn.com.tcsl.s1.java.classload.ClassA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    static {
        test /= 3;
    };


}
