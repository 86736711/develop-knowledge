package com.npf.knowledge.demo.java.create;

public class Child extends Parent{

    static {
        System.out.println("Child static create!");
    }

    public Child(){
        System.out.println("Child create!");
    }
}
