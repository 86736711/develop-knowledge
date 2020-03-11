package com.npf.knowledge.demo.design.interpreter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.interpreter
 * @ClassName: Test
 * @Author: ningpf
 * @Description: 解析器模式,是处理一些表达式数据的解析处理,像分库分表中的执行sql是解析，Spring的xml文件的解析都数据这个模式,这里只是简单的实现该模式
 * 如果要做好一个解析器模式还需要配合单例，组合，迭代器等模式
 * @Date: 2020/2/6 16:45
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        Expression expression = new Expression();

        expression.interpret("1 + 3");

        expression.interpret("3 - 1");
    }
}
