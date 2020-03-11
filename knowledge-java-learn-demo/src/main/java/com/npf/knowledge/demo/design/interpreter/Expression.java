package com.npf.knowledge.demo.design.interpreter;

/**
 * @ProjectName: tcsl-smart-demo
 * @Package: cn.com.tcsl.s1.design.interpreter
 * @ClassName: Expression
 * @Author: ningpf
 * @Description: ${description}
 * @Date: 2020/2/6 17:10
 * @Version: 1.0
 */
public class Expression {

    private Add add;
    private Subtract sub;
    
    public Expression(){
        add = new Add();
        
        sub = new Subtract();
    }
    
    public void interpret(String context){

        String[] ctx = context.split(" ");
        if(ctx[1].equals("+")){
            int sum = this.add.add(Integer.parseInt(ctx[0]), Integer.parseInt(ctx[2]));

            System.out.println("="+sum);
        }else if(ctx[1].equals("-")){
            int sub = this.sub.sub(Integer.parseInt(ctx[0]), Integer.parseInt(ctx[2]));

            System.out.println("="+sub);
        }
    }


}
