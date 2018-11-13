package com.wh.core.patterns;
/**
 * 单例模式
 * @ClassName: Singleton 
 * @author: 59533
 * @date: 2018年8月28日 下午3:25:02
 */
public class Singleton {
	private Singleton(){

	}

	private static class SingletonBuild{
		private static Singleton singleton = new Singleton();
	}

	public Singleton getInstance(){  
		return  SingletonBuild.singleton ;
	}

}
