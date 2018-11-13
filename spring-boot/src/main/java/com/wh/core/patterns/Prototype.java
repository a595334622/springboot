package com.wh.core.patterns;
/**
 * 原型模式
 * @ClassName: Prototype 
 * @author: 59533
 * @date: 2018年8月28日 下午4:07:44
 */
public class Prototype implements Cloneable{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone()   {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main ( String[] args){
        Prototype pro = new Prototype();
        Prototype pro1 = (Prototype)pro.clone();
    }
}