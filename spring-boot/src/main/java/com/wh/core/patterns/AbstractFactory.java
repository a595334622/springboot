package com.wh.core.patterns;
/**
 * 抽象工厂模式
 * @ClassName: AbstractFactory 
 * @author: 59533
 * @date: 2018年8月28日 下午3:07:08
 */
public class AbstractFactory {
	public void clientCode(String name){
		Foods x= new FactoryForA().get();
		x = new FactoryForB().get();
	}
}

interface Foods{}

class FoodsA implements Foods{}
class FoodsB implements Foods{}

interface Produce{
	/**
	 * get方法
	* @Title: get 
	* @Description: TODO 
	* @return Foods
	 */
	Foods get();
	}

class FactoryForA implements Produce{
	@Override
	public Foods get() {
		return new FoodsA();
	}
}
class FactoryForB implements Produce{
	@Override
	public Foods get() {
		return new FoodsB();
	}
}
