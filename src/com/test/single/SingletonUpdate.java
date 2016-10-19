package com.test.single;
/**
 * 懒加载单例模式多线程优化
 * @author Administrator
 *
 */
public class SingletonUpdate {

	private SingletonUpdate(){
		System.out.println("SingletonUpdate is created");
	}
	/**
	 * 内部类：内部类在SingletonUpdate加载的时候并不会加载
	 * 	确保SingletonUpdate被JVM加载时，不会初始化单例类
	 * 
	 * 	使用内部内实现单例，既可以做到延迟加载也不用synchronized关键字，
	 *  是一个比较完善的实现
	 * @author Administrator
	 *
	 */
	private static class SingletonUpdateHodler{
		private static SingletonUpdate instance = new SingletonUpdate();
	}
	
	public static SingletonUpdate getInstance(){
		return SingletonUpdateHodler.instance;
	}
}
