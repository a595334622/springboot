package com.wh.core.patterns;

/**
 *  工厂模式
* @ClassName: StaticFactory
* @author Devil
* @date 2018年8月26日
 */
public class StaticFactory {

    private StaticFactory(){}
    
    public static Food getA(){  return new FoodA(); }
    public static Food getB(){  return new FoodB(); }
    public static Food getC(){  return new FoodC(); }
}

interface Food{}

class FoodA implements Food{}
class FoodB implements Food{}
class FoodC implements Food{}

class Client{
	/**
	 * 客户端代码只需要将相应的参数传入即可得到对象
	 * 用户不需要了解工厂类内部的逻辑。
	 */
    public void get(String name){
        Food x = null ;
        String a = "A";
        String b = "B";
        
        if ( a.equals(name)) {
            x = StaticFactory.getA();
        }else if (b.equals(name)){
            x = StaticFactory.getB();
        }else {
            x = StaticFactory.getC();
        }
    }
}